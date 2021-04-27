const supertest = require("supertest");
const app = require("../../app");
const asserts = require("assert");

exports.subtraction_should_response_a_numeric_result = (done) => {
  supertest(app)
    .get("/subtract?a=4&b=5")
    .expect(200)
    .end((err, response) => {
      asserts.ok(!err);
      asserts.ok(typeof response.body.result === "number");
      return done();
    });
};
