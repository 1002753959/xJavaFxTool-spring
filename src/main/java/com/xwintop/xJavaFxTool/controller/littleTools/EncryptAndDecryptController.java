package com.xwintop.xJavaFxTool.controller.littleTools;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import de.felixroske.jfxsupport.FXMLController;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BinaryCodec;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.lang.StringUtils;

import com.xwintop.xJavaFxTool.utils.GuiUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

@FXMLController
public class EncryptAndDecryptController implements Initializable {
	@FXML
	private AnchorPane mainAnchorPane;
	@FXML
	private TextArea encrptyTextArea;
	@FXML
	private TextArea decrptyTextArea;
	@FXML
	private ChoiceBox<String> charsetsBox;
	@FXML
	private Button encrptyButton;
	@FXML
	private Button decrptyButton;

	private ToggleGroup toggleGroup = new ToggleGroup();
	/**
	 * 字符集.
	 */
	private String[] charsets = new String[] { GuiUtils.CHARSET_UTF_8, GuiUtils.CHARSET_UTF_16BE,
			GuiUtils.CHARSET_UTF_16LE, GuiUtils.CHARSET_UTF_16, GuiUtils.CHARSET_GBK, GuiUtils.CHARSET_Big5,
			GuiUtils.CHARSET_ISO_8859_1 };

	/**
	 * 加密算法. 空""用于填充一个空位.
	 */
	private String[] cryptos = new String[] { GuiUtils.CRYPTO_ASCII, GuiUtils.CRYPTO_HEX, GuiUtils.CRYPTO_BASE64,
			GuiUtils.CRYPTO_BASE32, GuiUtils.CRYPTO_URL, "", "", "", GuiUtils.CRYPTO_MD5, "", GuiUtils.CRYPTO_SHA,
			GuiUtils.CRYPTO_SHA256, GuiUtils.CRYPTO_SHA384, GuiUtils.CRYPTO_SHA512 };

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initView();
		initEvent();
	}

	private void initView() {
		charsetsBox.getItems().addAll(charsets);
		charsetsBox.setValue(charsetsBox.getItems().get(0));
		for (int i = 0; i < cryptos.length; i++) {
			if (!"".equals(cryptos[i])) {
				RadioButton radioButton = new RadioButton(cryptos[i]);
				radioButton.setLayoutX(440 + i % 2 * 100);
				radioButton.setLayoutY(60 + i / 2 * 26);
				radioButton.setToggleGroup(toggleGroup);
				radioButton.setUserData(cryptos[i]);
				mainAnchorPane.getChildren().add(radioButton);
				if (i == 0) {
					radioButton.setSelected(true);
				}
			}
		}
	}

	private void initEvent() {
	}

	@FXML
	private void encrptyAction(ActionEvent event) {// 加密
		String charSet = charsetsBox.getValue();
		String curCrypto = toggleGroup.getSelectedToggle().getUserData().toString();
		String string = encrptyTextArea.getText();
		if (StringUtils.isEmpty(string)) {
			decrptyTextArea.setText(null);
			return;
		}
		try {
			if (GuiUtils.CRYPTO_ASCII.equals(curCrypto)) {
				decrptyTextArea.setText(BinaryCodec.toAsciiString(string.getBytes(charSet)));
			} else if (GuiUtils.CRYPTO_HEX.equals(curCrypto)) {
				decrptyTextArea.setText(Hex.encodeHexString(string.getBytes(charSet)));
			} else if (GuiUtils.CRYPTO_BASE64.equals(curCrypto)) {
				decrptyTextArea.setText(new String(Base64.encodeBase64(string.getBytes(charSet))));
			} else if (GuiUtils.CRYPTO_BASE32.equals(curCrypto)) {
				Base32 base32 = new Base32();
				decrptyTextArea.setText(new String(base32.encode(string.getBytes(charSet))));
			} else if (GuiUtils.CRYPTO_URL.equals(curCrypto)) {
				decrptyTextArea.setText(new String(URLCodec.encodeUrl(null, string.getBytes(charSet)), charSet));
			} else if (GuiUtils.CRYPTO_MD5.equals(curCrypto)) {
				String md5Val = DigestUtils.md5Hex(string.getBytes(charSet));
				decrptyTextArea.setText("16Bit：" + md5Val.substring(8, 24) + "\n32Bit：" + md5Val);
			} else if (GuiUtils.CRYPTO_SHA.equals(curCrypto)) {
				decrptyTextArea.setText(DigestUtils.sha1Hex(string.getBytes(charSet)));
			} else if (GuiUtils.CRYPTO_SHA256.equals(curCrypto)) {
				decrptyTextArea.setText(DigestUtils.sha256Hex(string.getBytes(charSet)));
			} else if (GuiUtils.CRYPTO_SHA384.equals(curCrypto)) {
				decrptyTextArea.setText(DigestUtils.sha384Hex(string.getBytes(charSet)));
			} else if (GuiUtils.CRYPTO_SHA512.equals(curCrypto)) {
				decrptyTextArea.setText(DigestUtils.sha512Hex(string.getBytes(charSet)));
			}
		} catch (UnsupportedEncodingException e) {
			decrptyTextArea.setText(e.getMessage());
		}
	}

	@FXML
	private void decrptyAction(ActionEvent event) {// 解密
		String charSet = charsetsBox.getValue();
		String curCrypto = toggleGroup.getSelectedToggle().getUserData().toString();
		String string = decrptyTextArea.getText();
		if (StringUtils.isEmpty(string)) {
			decrptyTextArea.setText(null);
			return;
		}
		try {
			if (GuiUtils.CRYPTO_ASCII.equals(curCrypto)) {
				encrptyTextArea.setText(new String(BinaryCodec.fromAscii(string.toCharArray()), charSet));
			} else if (GuiUtils.CRYPTO_HEX.equals(curCrypto)) {
				encrptyTextArea.setText(new String(Hex.decodeHex(string.toCharArray()), charSet));
			} else if (GuiUtils.CRYPTO_BASE64.equals(curCrypto)) {
				encrptyTextArea.setText(new String(Base64.decodeBase64(string.getBytes(charSet)), charSet));
			} else if (GuiUtils.CRYPTO_BASE32.equals(curCrypto)) {
				Base32 base32 = new Base32();
				encrptyTextArea.setText(new String(base32.decode(string.getBytes(charSet)), charSet));
			} else if (GuiUtils.CRYPTO_URL.equals(curCrypto)) {
				encrptyTextArea.setText(new String(URLCodec.decodeUrl(string.getBytes(charSet)), charSet));
			} else {
				encrptyTextArea.setText("不支持此种加密算法的解密！");
			}
		} catch (Exception e) {
			encrptyTextArea.setText(e.getMessage());
		}
	}
}
