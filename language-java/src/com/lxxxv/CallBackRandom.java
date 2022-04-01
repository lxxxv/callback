package com.lxxxv;

import java.util.Optional;
import java.util.Random;
import java.util.function.*;

public class CallBackRandom
{
    private final int MAX_LOOP = 1000;

    private void buildString(int _maxLoop, Consumer<String> _caller)
    {
        try
        {
            Optional<Consumer> caller = Optional.of(_caller);

            Random rm = new Random();
            int idx = 0;
            while (idx < _maxLoop)
            {
                _caller.accept(Integer.toString(rm.nextInt()) + "_" + Integer.toString(idx));
                idx++;
            }
        }
        catch(Exception e)
        {

        }
    }

    public void getStringConsumer(Consumer<String> _caller) {this.getStringConsumer(MAX_LOOP, _caller);}
    public void getStringSupplier(Supplier<String> _caller)
    {
        this.getStringSupplier(MAX_LOOP, _caller);
    }
    public void getStringFunction(Function<String, String> _caller) {this.getStringFunction(MAX_LOOP, _caller);}

    public void getStringConsumer(int _maxLoop, Consumer<String> _caller)
    {
        try
        {
            Optional<Consumer> caller = Optional.of(_caller);
            this.buildString
            (
                _maxLoop, (Sender)->
                {
                    _caller.accept("Consumer "+Sender);
                }
            );
        }
        catch(Exception e)
        {

        }
    }
    public void getStringSupplier(int _maxLoop, Supplier<String> _caller)
    {
        try
        {
            Optional<Supplier> caller = Optional.of(_caller);
            this.buildString
            (
                _maxLoop, (Sender)->
                {
                    String tmp = _caller.get();
                }
            );
        }
        catch(Exception e)
        {

        }
    }
    public void getStringFunction(int _maxLoop, Function<String, String> _caller)
    {
        try
        {
            Optional<Function> caller = Optional.of(_caller);
            this.buildString
            (
                _maxLoop, (Sender)->
                {
                    String cnv = _caller.apply("Function "+Sender);
                    System.out.println(cnv);
                }
            );
        }
        catch(Exception e)
        {

        }
    }
}
