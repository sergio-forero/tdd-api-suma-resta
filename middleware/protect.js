module.exports = (req, res, next) => {
  var a = parseInt(req.query.a),
    b = parseInt(req.query.b);
  req.a = a;
  req.b = b;
  if (
    !a ||
    !b ||
    isNaN(a) ||
    isNaN(b) ||
    Object.keys(req.query).length > 2 ||
    Object.keys(req.query).length < 2
  ) {
    res.status(422).end();
  } else {
    return undefined || next();
  }
};
