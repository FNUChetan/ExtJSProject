Ext.define('App.model.Question', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'quesNo', type: 'int' },
        { name: 'ques', type: 'string' },
        { name: 'option1', type: 'string' },
        { name: 'option2', type: 'string' },
        { name: 'option3', type: 'string' },
        { name: 'option4', type: 'string' }
    ]
});