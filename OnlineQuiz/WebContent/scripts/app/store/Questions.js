Ext.define('App.store.Questions', {
    extend: 'Ext.data.Store',
    model: 'App.model.Question',
    proxy: {
        type: 'rest',
        url: 'spring/rest/questions',
        
        reader: {
            type: 'json'            
        }
    }
});
