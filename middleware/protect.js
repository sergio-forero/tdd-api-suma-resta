
module.exports = (req, res, next)=>{
    var eventError = undefined;
    var a = parseInt(req.query.a),
    b = parseInt(req.query.b);
    req.a = a;
    req.b = b;
    if(!a || !b || isNaN(a) || isNaN(b) || Object.keys(req.query).length>2 || Object.keys(req.query).length<2){
        eventError = res.status(422).end("Estas enviando los parametros de forma equivocada, deben ser dos 'a' y 'b', y deben ser numericos" );
    }else{
        return eventError || next();
    }
}
