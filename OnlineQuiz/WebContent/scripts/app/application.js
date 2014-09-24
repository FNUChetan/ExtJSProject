Ext.require('Ext.container.Viewport');
Ext.application({
    name: 'App',
    appFolder: 'scripts/app',
    /*models: ['Question'],
    stores: ['Questions'],
    views: ['QuestionDisplay'],*/
    controllers: ['QuestionController'],
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [{
                    xtype: 'questiondisp'
                }]
        });
    }
});