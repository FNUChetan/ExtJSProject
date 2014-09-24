Ext.define('App.controller.QuestionController', {
	extend : 'Ext.app.Controller',

	models : [ 'Question' ],

	stores : [ 'Questions' ],

	views : [ 'QuestionDisplay' ],

	init : function() {
		this.getQuestionsStore().load();
	}
});