package com.lxxxv;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

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

    public void getString(Consumer<String> _caller)
    {
        this.getString(MAX_LOOP, _caller);
    }

    public void getString(int _maxLoop, Consumer<String> _caller)
    {
        try
        {
            Optional<Consumer> caller = Optional.of(_caller);
            this.buildString(_maxLoop, (Sender)->_caller.accept(Sender));
        }
        catch(Exception e)
        {

        }
    }

    public void getString(Supplier<String> _caller)
    {
        this.getString(MAX_LOOP, _caller);
    }

    public void getString(int _maxLoop, Supplier<String> _caller)
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
}
