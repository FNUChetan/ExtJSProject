Ext.define('App.view.PanelTest', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.paneltest',
    title: 'Button Test',
    width: 350,
    height: 300,
    layout: 'card',
    deferredRender: true,
    style: 'margin: 50px', // move panel off browser's edge
    renderTo: Ext.getBody(),
    
    //store : 'Questions',
    
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
        //alert("questionStores Initialization");
        var questionStores = Ext.data.StoreManager.lookup('Questions');
        //alert("questionStores Loading");
        questionStores.load({
        	callback: function(){
        		Ext.Msg.alert('Store Count', questionStores.count());
        	}
        });
        //alert("Load Complete");
        
        this.callParent(arguments);
    }
});