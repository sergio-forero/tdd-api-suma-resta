var express = require('express');
var validacion = require('./middleware/protect');

app = express();

app.use(validacion);

app.set('port', process.env.PORT || 3000);

app.get('/add', require('./controller/add'));
app.get('/subtract', require('./controller/subtract'));

app.listen(app.get('port'), ()=>{
    console.log('App is listening - localhost:' + app.get('port'));
});

module.exports = app;
