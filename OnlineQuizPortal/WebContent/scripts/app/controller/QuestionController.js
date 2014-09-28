Ext.define('App.controller.QuestionController', {
	extend : 'Ext.app.Controller',

	models : [ 'Question' ],

	stores : [ 'Questions' ],

	views : [ 'QuestionDisplay', 'PanelTest', 'MyButton' ],

	init : function() {
		
		//Ext.data.StoreManager.lookup('Questions').load();
		/*alert("After clicking OK, Store will be loaded");
		this.getQuestionsStore().load();*/
	}
});