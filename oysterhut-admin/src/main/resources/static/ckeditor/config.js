/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    config.removeDialogTabs = 'image:advanced;image:Link';//去掉编辑器中文件上传的选项中把"超链接"和"高级去掉"
	config.image_previewText = '';
	config.filebrowserUploadUrl='/uploadImg'//上传图片路径
	config.height = 400; //高度
};
