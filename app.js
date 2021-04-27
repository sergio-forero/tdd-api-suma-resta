var express = require('express');
var validacion = require('./middleware/protect');

app = express();

app.use(validacion);

app.get('/add', require('./controller/add'));
app.get('/subtract', require('./controller/subtract'));

app.listen(3000, ()=>{
console.log('App is listening - localhost:3000');
});

module.exports = app;