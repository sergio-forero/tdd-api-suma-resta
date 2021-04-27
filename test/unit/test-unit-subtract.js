var assert = require('assert'),
subtract = require('../../lib/subtract');

exports.it_should_subtract_two_numbers = (done)=>{
    var result = subtract(1,1);
    assert.ok(result === 0);
    return done();
}

exports.it_should_subtract_two_numbers_one_negative_and_one_positive= (done)=>{
    var result = subtract(-2,2);
    assert.ok(result === -4);
    return done();
}