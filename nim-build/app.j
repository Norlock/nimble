.class public App
    .super java/lang/Object

    ; Default constructor (empty constructor)
    .method public <init>()V
        aload_0                                     ; Loads "this" on the stack
        invokenonvirtual java/lang/Object/<init>()V ; Call super constructor
        return                                      ; Terminate method
    .end method
    
    ; Method definition for public static void main(String[] args)
    .method public static main([Ljava/lang/String;)V
        .limit stack 100
        .limit locals 100

		iconst_2
		istore_1
		iconst_3
		istore_2
		getstatic java/lang/System.out Ljava/io/PrintStream;
		iload_1
		iload_2
		iadd
		invokevirtual java/io/PrintStream/println(I)V
        return
    .end method
