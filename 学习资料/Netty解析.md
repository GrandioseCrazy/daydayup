#BIO
客户端监听Accept阻塞的
读写socket时，Read是阻塞的
读写socker时，Write是阻塞的
Accept之后要开启一个线程去等待读写事件 n个客户端就要开n个线程 极大影响性能


`final Socket socket = serverSocket.accept();`

接收到这个socket后获取socket的输入流

`InputStream inputStream = socket.getInputStream();`

再然后就到阻塞方法了

` int read = inputStream.read(bytes);`

获取输入流必须开启多线程 否则无法绑定多个socket 一个服务器只能连一个socket

#NIO
基于事件机制
一个线程把Accept和读写操作全做了
##Reactor单线程模型
一个NIO线程 + 一个accept线程
##Reactor主从模型

