# lmax-example
[![Build Status](https://travis-ci.org/gregwhitaker/lmax-example.svg?branch=master)](https://travis-ci.org/gregwhitaker/lmax-example)

A simple example of using the [LMAX Disruptor](https://lmax-exchange.github.io/disruptor/) with multiple event types.

The example contains two event types, `HelloEvent` and `GoodbyeEvent`, as well as three event handlers. One handler handles 
HelloEvents, another GoodbyeEvents, and a third handles all of the above types.

## Running the Example
Run the following command to start the example application:

    ./gradlew run