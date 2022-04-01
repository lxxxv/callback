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
            Consumer<String> caller = Optional.of(_caller).orElseThrow(NullPointerException::new);

            Random rm = new Random();
            int idx = 0;
            while (idx < _maxLoop)
            {
                caller.accept(Integer.toString(rm.nextInt()) + "_" + Integer.toString(idx));
                idx++;
            }
        }
        catch(Exception e)
        {

        }
    }

    public void getStringConsumer(Consumer<String> _caller) {this.getStringConsumer(MAX_LOOP, _caller);}
    public void getStringSupplier(Supplier<String> _caller) {this.getStringSupplier(MAX_LOOP, _caller);}
    public void getStringFunction(Function<String, String> _caller) {this.getStringFunction(MAX_LOOP, _caller);}
    public void getStringOperator(BinaryOperator<String> _caller){this.getStringOperator(MAX_LOOP, _caller);}

    public void getStringConsumer(int _maxLoop, Consumer<String> _caller)
    {
        try
        {
            Consumer<String> caller = Optional.of(_caller).orElseThrow(NullPointerException::new);

            this.buildString
            (
                _maxLoop, (Sender)->
                {
                    caller.accept("Consumer "+Sender);
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
            Supplier<String> caller = Optional.of(_caller).orElseThrow(NullPointerException::new);

            this.buildString
            (
                _maxLoop, (Sender)->
                {
                    String tmp = caller.get();
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
            Function<String, String> caller = Optional.of(_caller).orElseThrow(NullPointerException::new);

            this.buildString
            (
                _maxLoop, (Sender)->
                {
                    String cnv = caller.apply("Function "+Sender);
                    System.out.println(cnv);
                }
            );
        }
        catch(Exception e)
        {

        }
    }
    public void getStringOperator(int _maxLoop, BinaryOperator<String> _caller)
    {
        try
        {
            BinaryOperator<String> caller = Optional.of(_caller).orElseThrow(NullPointerException::new);

            this.buildString
            (
                _maxLoop, (Sender)->
                {
                    String tmp = caller.apply(Sender, Sender + "aa");
                }
            );
        }
        catch(Exception e)
        {

        }
    }
}
