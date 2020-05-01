FROM payara/micro:5.191
COPY client/target/ROOT.war /opt/payara/deployments

CMD ["--nocluster", "--deploymentDir", "/opt/payara/deployments"]