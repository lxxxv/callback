package com.lxxxv;

import java.util.Optional;
import java.util.function.*;
import java.lang.Exception;

public class Main
{

    public static void main(String[] args)
    {
        new CallBackRandom().getStringConsumer(null);


        //
        // getStringConsumer 내부에서 수행 후 결과를 호출자의 파라미터로 전달
        //
        new CallBackRandom().getStringConsumer
        (
            5, (Sender)->
            {
                System.out.println(Sender);
            }
        );

        //
        // getStringFunction 내부에서 수행 할 때 호출자의 파라미터의 값을 참조 받는다.
        //
        new CallBackRandom().getStringFunction
        (
            (sender)->
            {
                return sender + " a";
            }
        );

        new CallBackRandom().getStringOperator
        (
            (a, b)->
            {
                if (a.equals(b))
                {
                    return a;
                }
                else
                {
                    return b;
                }
            }
        );
    }
}
