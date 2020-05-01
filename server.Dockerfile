FROM payara/micro:5.201
COPY server/target/ROOT.war /opt/payara/deployments

CMD ["--nocluster", "--deploymentDir", "/opt/payara/deployments"]