package com.xwintop.xJavaFxTool.controller.developTools;

import com.xwintop.xJavaFxTool.view.developTools.AsciiPicToolView;
import com.xwintop.xJavaFxTool.services.developTools.AsciiPicToolService;
import com.xwintop.xcore.util.javafx.FileChooserUtil;
import de.felixroske.jfxsupport.FXMLController;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.context.annotation.Lazy;

/**
 * @ClassName: AsciiPicToolController
 * @Description: 图片转ascii
 * @author: xufeng
 * @date: 2017/12/24 0024 23:18
 */
@Getter
@Setter
@Log4j
@Lazy
@FXMLController
public class AsciiPicToolController extends AsciiPicToolView {
    private AsciiPicToolService asciiPicToolService = new AsciiPicToolService(this);
    private String[] imageSize = new String[]{"不压缩", "60*60","120*120", "256*256", "512*512"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initView();
        initEvent();
        initService();
    }

    private void initView() {
        imageSizeComboBox.getItems().addAll(imageSize);
        imageSizeComboBox.getSelectionModel().select(0);
    }

    private void initEvent() {
        FileChooserUtil.setOnDrag(filePathTextField, FileChooserUtil.FileType.FILE);
    }

    private void initService() {
    }

    @FXML
    private void filePathAction(ActionEvent event) {
        File file = FileChooserUtil.chooseFile();
        if (file != null) {
            filePathTextField.setText(file.getPath());
        }
    }

    @FXML
    private void buildAction(ActionEvent event) {
        asciiPicToolService.buildAction();
    }
}