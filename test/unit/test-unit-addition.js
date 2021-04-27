var assert = require("assert"),
  add = require("../../lib/add");

exports.it_should_add_two_numbers = (done) => {
  var result = add(1, 1);
  assert.ok(result === 2);
  return done();
};

exports.it_should_add_two_numbers_negative = (done) => {
  var result = add(-1, -1);
  assert.ok(result === -2);
  return done();
};
