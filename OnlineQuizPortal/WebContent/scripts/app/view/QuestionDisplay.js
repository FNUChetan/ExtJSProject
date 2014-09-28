Ext.define('App.view.QuestionDisplay', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.questiondisp',
    title: 'Online Quiz',
    width: 350,
    height: 300,
    layout: 'card',
    deferredRender: true,
    style: 'margin: 50px', // move panel off browser’s edge
    renderTo: Ext.getBody(),
    
    store : 'Questions',
    
    items: [],
    
    bbar: ['->', {
            xtype: 'button',
            text: 'Previous',
            disabled: true,
            handler: function(btn) {
                var v = this.up();
                var vDown = v.down('button[text="Submit"]');
                if (vDown != null)
                {
                    vDown.setText('Next');
                }
                var layout = me.getLayout();

                if (layout.getPrev()) {
                    layout.prev();
                    if (!layout.getPrev()) {
                        btn.setDisabled(true);
                    }
                }
            }
        }, {
            xtype: 'button',
            text: 'Next',
            handler: function(btn) {
                var v = this.up();
                var vDown = v.down('button[text="Previous"]');
                vDown.setDisabled(false);
                var layout = me.getLayout();

                if (layout.getNext()) {
                    layout.next();
                    if (!layout.getNext()) {
                        btn.setText('Submit');
                    }
                }
            }
        }],
    initComponent: function() {
        me = this;
        var questionStores = Ext.data.StoreManager.lookup('Questions');
        var panelItems = [];
        for (var i = 0; i < questionStores.count(); i++) {
            panelItems[i] = {
                id: 'question' + questionStores.data.items[i].quesNo,
                title: 'Question ' + (i + 1),
                html: questionStores.data.items[i].ques + '<br><br>' + questionStores.data.items[i].option1 + '<br><br>' + questionStores.data.items[i].option2 + '<br><br>' + questionStores.data.items[i].option3 + '<br><br>' + questionStores.data.items[i].option4
            };
        }
        this.items = panelItems;
        this.callParent(arguments);
    }
});