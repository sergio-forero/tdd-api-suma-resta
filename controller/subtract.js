var subtract = require('../lib/subtract');

module.exports = (req, res, next)=>{
    return res.json({result : subtract(req.a, req.b)});
}