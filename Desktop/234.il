.assembly extern mscorlib{}
.assembly C:\Users\usuario1\Desktop\234{}
.module C:\Users\usuario1\Desktop\234.exe

.class public _Principal{
    .method public static void _Principal ()
    {
        .entrypoint
        ldc.i8 1
        call void [mscorlib]System.Console::Write(int64)
        ldc.i8 1
        call void [mscorlib]System.Console::Write(int64)
        ldc.i8 5
        call void [mscorlib]System.Console::Write(int64)
        ret
        }
