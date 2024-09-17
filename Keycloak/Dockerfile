FROM quay.io/keycloak/keycloak:latest as builder

#Custom Keycloak Theme
ARG CUSTOM_KEYCLOAK_THEME_DIR=custom
ARG CONTAINER_KEYCLOAK_THEME_DIR=opt/keycloak/themes/custom

RUN mkdir ${CONTAINER_KEYCLOAK_THEME_DIR}

COPY ${CUSTOM_KEYCLOAK_THEME_DIR} ${CONTAINER_KEYCLOAK_THEME_DIR}

WORKDIR /opt/keycloak
# for demonstration purposes only, please make sure to use proper certificates in production instead
RUN keytool -genkeypair -storepass password -storetype PKCS12 -keyalg RSA -keysize 2048 -dname "CN=server" -alias server -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -keystore conf/server.keystore
RUN /opt/keycloak/bin/kc.sh build
