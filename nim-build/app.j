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
		iconst_3
		if_icmplt label1
		iconst_1
		goto label3
		label1:
		iconst_0
		label3:
		istore_1
		getstatic java/lang/System.out Ljava/io/PrintStream;
		newjava/lang/StringBuilder
		dup
		invokespecial java/lang/StringBuilder."<init>":()V
		ldc "test"
		invokevirtual java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
		iload_1
		invokevirtual java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
		invokevirtual java/lang/StringBuilder.toString:()Ljava/lang/String;
		invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
        return
    .end method
