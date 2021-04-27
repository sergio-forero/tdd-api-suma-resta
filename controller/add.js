var add = require("../lib/add");

module.exports = (req, res, next) => {
  return res.json({ result: add(req.a, req.b) });
};
