# user-service project

This project is to show how to use quarkus to integrate with Kubernetes.

### Prerequisites
- JDK 11+
- pache Maven 3.6.2+
- Kubernetes cluster
- MongoDB 4+

### Add K8S extension
```bash
./mvnw quarkus:add-extension -Dextensions="container-image-jib,quarkus-kubernetes"
```

### Deploying Quarkus app to Kubernetes

- build a container image and generate K8S manifests
```bash
./mvnw clean package
```

- show K8S manifests
```bash
cat target/kubernetes/kubernetes.yml
```

- to create and push your container image using jib
```bash
./mvnw clean package -Dquarkus.container-image.push=true
```

- Deploy your application to your Kubernetes cluster
```bash
kubectl apply -f target/kubernetes/kubernetes.json
```

If you want to learn more about deploying the application to the K8S platform, please visit https://quarkus.io/guides/deploying-to-kubernetes.

