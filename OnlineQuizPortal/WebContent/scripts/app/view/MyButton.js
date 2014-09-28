Ext.define('App.view.MyButton', {
	extend: 'Ext.Button',
	alias: 'widget.mybutton',
    text: 'Click me',
    scale   : 'large',
    handler: function() {
        alert('You clicked the button!');
    }
});