const supertest = require("supertest");
const app = require("../../app");

exports.addition_should_accept_numbers = (done) => {
  supertest(app).get("/add?a=1&b=1").expect(200).end(done);
};

exports.addition_should_reject_string = (done) => {
  supertest(app).get("/add?a=string&b=1").expect(422).end(done);
};
