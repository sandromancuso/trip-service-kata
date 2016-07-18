class DependendClassCallDuringUnitTestException < StandardError
    def initialize(msg)
        super(msg)
    end
end