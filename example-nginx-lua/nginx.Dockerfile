# FROM alpine:3.17.1 AS builder
# RUN apk add --update-cache build-base lua5.3-dev && \
#         wget https://luarocks.org/releases/luarocks-3.3.1.tar.gz && \
#         tar xzf luarocks-3.3.1.tar.gz && \
#         cd luarocks-3.3.1 && \
#         ./configure --lua-suffix=5.3 --with-lua-include=/usr/include/lua5.3 && \
#         make build && make install

# FROM nginx:1.23.3-alpine
# RUN apk add --update-cache --no-cache \
#         unzip \
#         build-base \
#         lua5.3-dev \
#         luajit-dev \
#         luajit \
#         openssl-dev \
#         pcre-dev \
#         zlib-dev && \
#     wget https://luarocks.org/releases/luarocks-3.3.1.tar.gz && \
#     tar xzf luarocks-3.3.1.tar.gz && \
#     cd luarocks-3.3.1 && \
#     ./configure --lua-suffix=5.3 --with-lua-include=/usr/include/lua5.3 && \
#     make build && make install && \
#     luarocks install lua-nginx-module && \
#     rm -rf /var/cache/apk/*

# COPY nginx.conf /etc/nginx/nginx.conf

# FROM nginx:1.23.3

# RUN apt-get update && apt-get install -y git wget lua5.3 liblua5.3-dev luajit
# RUN wget https://nginx.org/download/nginx-1.23.3.tar.gz
# RUN tar -xvf nginx-1.23.3.tar.gz
# RUN git clone https://github.com/openresty/lua-nginx-module.git
# RUN cd nginx-1.23.3/ && \
#     ./configure --with-compat --add-dynamic-module=../lua-nginx-module && \
#     make modules && \
#     cp objs/ngx_http_lua_module.so /etc/nginx/modules

FROM ubuntu:18.04

RUN apt-get update && apt-get install -y wget libpcre3-dev zlib1g-dev libssl-dev build-essential unzip lua5.1

RUN wget https://github.com/openresty/lua-nginx-module/archive/v0.10.22.zip && \
    unzip v0.10.22.zip && \
    rm v0.10.22.zip

RUN wget https://openresty.org/download/nginx-1.19.3.tar.gz && \
    tar -xzvf nginx-1.19.3.tar.gz && \
    rm nginx-1.19.3.tar.gz

RUN wget https://github.com/openresty/luajit2/archive/refs/tags/v2.1-20230119.tar.gz && \
    tar xzf v2.1-20230119.tar.gz && \
    rm v2.1-20230119.tar.gz && \
    cd luajit2-2.1-20230119 && \
    make install PREFIX=/usr/local

WORKDIR nginx-1.19.3

RUN export LUAJIT_LIB=/usr/local/bin && \
    export LUAJIT_INC=/usr/local/include/luajit-2.1 && \
    ./configure --add-dynamic-module=../lua-nginx-module-0.10.22 && \
    make
RUN make install
RUN wget https://github.com/openresty/lua-resty-core/archive/refs/tags/v0.1.24.tar.gz && \
    tar xzf v0.1.24.tar.gz && \
    cd lua-resty-core-0.1.24 && \
    make && \
    make install PREFIX=/opt/nginx
RUN wget https://github.com/openresty/lua-resty-lrucache/archive/refs/tags/v0.13.tar.gz && \
    tar xzf v0.13.tar.gz && \
    cd lua-resty-lrucache-0.13 && \
    make && \
    make install PREFIX=/opt/nginx

COPY nginx.conf /etc/nginx/nginx.conf
CMD ["/usr/local/nginx/sbin/nginx", "-c", "/etc/nginx/nginx.conf", "-g", "daemon off;"]