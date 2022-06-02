-- Git报错解决：OpenSSL SSL_read: Connection was reset, errno 10054 错误解决
   git config --global http.sslVerify "false"


一般是因为 无法访问 github 导致的

git config --global http.proxy 查询代理

git config --global --unset http.proxy 取消代理

git config --global http.proxy localhost:51525 设置代理

git config --global https.proxy localhost:51525

git config --global user.name "haozedev"

git config --global user.email "1823390765@qq.com"

弱引用配置
-Xms5m -Xmx5m -XX:+PrintGCDetails
