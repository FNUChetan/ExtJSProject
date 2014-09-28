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
        questionStores.load({
        	callback: function(){
        		Ext.Msg.alert('Store Count', questionStores.count());
                var panelItems = [];
                var i=0;
                /*for (var i = 0; i < questionStores.count(); i++) {
                    
                }*/
                /*questionStores.each( function(record){
                	panelItems[++i] = {
                            id: 'question' + record.get("quesNo"),
                            title: 'Question ' + (record.get("quesNo") + 1),
                            html: record.get("ques") + '<br><br>' + record.get("option1") + '<br><br>' + record.get("option2") + '<br><br>' + record.get("option3") + '<br><br>' + record.get("option4")
                        };
                });*/
                
                questionStores.each(function(record){
                	console.log('Question ' + record.get('quesNo'));
                	console.log(record.get('ques'));
                	console.log(record.get('option1'));
                	console.log(record.get('option2'));
                	console.log(record.get('option3'));
                	console.log(record.get('option4'));
                	panelItems[i++] = {
                            id: 'question' + record.get('quesNo'),
                            title: 'Question ' + record.get('quesNo'),
                            html: record.get('ques') + record.get('option1') + record.get('option2') + record.get('option3') + record.get('option4')
                        };
                	
                	//console.log('panelItems ' + panelItems);
                });
                console.log("me",me);
                console.log("me.items", me.items);
                console.log("this", this);
                me.items = panelItems;
                console.log(me.items[0]);
        	},
        	scope: me
        });
        
        this.callParent(arguments);
    }
});