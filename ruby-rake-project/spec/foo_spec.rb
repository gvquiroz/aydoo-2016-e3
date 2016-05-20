require 'rspec' 
require_relative '../model/foo'

describe 'Foo' do

	it 'should return foo when doFoo' do
		foo = Foo.new
		expect(foo.doFoo).to eq 'foo'
	end

end