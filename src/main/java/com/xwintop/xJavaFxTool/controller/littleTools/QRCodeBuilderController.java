package com.xwintop.xJavaFxTool.controller.littleTools;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import de.felixroske.jfxsupport.FXMLController;
import org.apache.commons.lang.StringUtils;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.xwintop.xJavaFxTool.Main;
import com.xwintop.xJavaFxTool.utils.QRCodeUtil;
import com.xwintop.xJavaFxTool.utils.ScreenShoter;
import com.xwintop.xJavaFxTool.view.littleTools.QRCodeBuilderView;
import com.xwintop.xcore.util.javafx.FileChooserUtil;
import com.xwintop.xcore.util.javafx.TooltipUtil;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import org.springframework.context.annotation.Lazy;

@Lazy
@FXMLController
public class QRCodeBuilderController extends QRCodeBuilderView{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initView();
		initEvent();
	}

	private void initView() {
		codeFormatChoiceBox.getItems().addAll("utf-8", "gb2312", "ISO-8859-1", "US-ASCII", "utf-16");
		codeFormatChoiceBox.setValue("utf-8");
		onColorColorPicker.setValue(Color.BLACK);
		offColorColorPicker.setValue(Color.WHITE);
		errorCorrectionLevelChoiceBox.getItems().addAll(ErrorCorrectionLevel.L, ErrorCorrectionLevel.M,
				ErrorCorrectionLevel.Q, ErrorCorrectionLevel.H);
		errorCorrectionLevelChoiceBox.setValue(ErrorCorrectionLevel.H);
		marginChoiceBox.getItems().addAll(1, 2, 3, 4);
		marginChoiceBox.setValue(1);
		formatImageChoiceBox.getItems().addAll("png", "jpg", "gif", "jpeg", "bmp");
		formatImageChoiceBox.setValue("png");
	}

	private void initEvent() {
		// 第一步：注册热键，第一个参数表示该热键的标识，第二个参数表示组合键，如果没有则为0，第三个参数为定义的主要热键
		try {
			JIntellitype.getInstance().registerHotKey(0, JIntellitype.MOD_ALT, (int) 'S');
			// 第二步：添加热键监听器
			JIntellitype.getInstance().addHotKeyListener(new HotkeyListener() {
				@Override
				public void onHotKey(int markCode) {
					switch (markCode) {
					case 0:
						snapshotAction(null);
						break;
					}
				}
			});
		} catch (Exception e) {
			TooltipUtil.showToast("热键注册失败。");
		}
		contentTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
				Platform.runLater(() -> {
					builderAction(null);
				});
			}
		});
	}

	@FXML
	private void builderAction(ActionEvent event) {
		if (StringUtils.isEmpty(contentTextField.getText())) {
			return;
		}
		try {
			Image image = QRCodeUtil.toImage(contentTextField.getText(), (int) codeImageView.getFitWidth(),
					(int) codeImageView.getFitHeight(), codeFormatChoiceBox.getValue(),
					errorCorrectionLevelChoiceBox.getValue(), marginChoiceBox.getValue(), onColorColorPicker.getValue(),
					offColorColorPicker.getValue(), formatImageChoiceBox.getValue());
			codeImageView.setImage(image);
			if(logoCheckBox.isSelected() && codeImageView1.getImage()!=null){
				Image image1 = QRCodeUtil.encodeImgLogo(image, codeImageView1.getImage(),(int) logoSlider.getValue());
				codeImageView.setImage(image1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void snapshotAction(ActionEvent event) {
		// 默认情况下，Fx运行时会在最后一个stage的close(或hide)后自动关闭，即自动调用Application.stop()
		// 除非通过Platform.setImplicitExit(false)取消这个默认行为。这样,即使所有Fx窗口关闭（或隐藏）,Fx运行时还在正常运行
		Platform.setImplicitExit(false);
		// Main.getStage().setIconified(true);
		if (Main.getStage().isShowing()) {
			Platform.runLater(() -> {
				Main.getStage().hide();
			});
		}
		// new SnapshotRectUtil(this);
		new ScreenShoter(this);
	}
	
	@FXML
	private void snapshotDesktopAction(ActionEvent event) throws Exception {
		Platform.setImplicitExit(false);
		try {
			Main.getStage().hide();
			Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
			Robot robot = new Robot();
			BufferedImage screenImg = robot.createScreenCapture(
					new Rectangle(0, 0, SCREEN_SIZE.width, SCREEN_SIZE.height));
			Main.getStage().show();
			String code = QRCodeUtil.toDecode(screenImg);
			if (StringUtils.isNotEmpty(code)) {
				contentTextField.setText(code);
			}else{
				Platform.runLater(() -> {
					TooltipUtil.showToast("未识别到二维码。");
				});
			}
		} catch (Exception e) {
			TooltipUtil.showToast("发生异常:"+e.getMessage());
		}finally {
			Platform.setImplicitExit(true);
		}
	}

	@FXML
	private void saveAction(ActionEvent event) throws Exception {
		String fileName = "x"+new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+"."+formatImageChoiceBox.getValue();
		File file = FileChooserUtil.chooseSaveFile(fileName, new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"),
				new FileChooser.ExtensionFilter("gif", "*.gif"), new FileChooser.ExtensionFilter("jpeg", "*.jpeg"),
				new FileChooser.ExtensionFilter("bmp", "*.bmp"));
		if (file != null) {
			String[] fileType = file.getPath().split("\\.");
			ImageIO.write(SwingFXUtils.fromFXImage(codeImageView.getImage(), null), fileType[fileType.length - 1],
					file);
			TooltipUtil.showToast("保存图片成功,图片在："+file.getPath());
		}
	}
	@FXML
	private void logoAction(ActionEvent event) throws Exception {
		File file = FileChooserUtil.chooseFile(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"),
				new FileChooser.ExtensionFilter("gif", "*.gif"), new FileChooser.ExtensionFilter("jpeg", "*.jpeg"),
				new FileChooser.ExtensionFilter("bmp", "*.bmp"));
		if (file != null) {
			Image image = SwingFXUtils.toFXImage(ImageIO.read(file),null);
			codeImageView1.setImage(image);
		}
	}

	public void snapshotActionCallBack(Image image) {
		Platform.runLater(() -> {
			// Main.getStage().setIconified(false);
			Main.getStage().show();
		});
		codeImageView1.setImage(image);
		String code = QRCodeUtil.toDecode(image);
		if (StringUtils.isNotEmpty(code)) {
			contentTextField.setText(code);
		}
		Platform.setImplicitExit(true);
	}
}
