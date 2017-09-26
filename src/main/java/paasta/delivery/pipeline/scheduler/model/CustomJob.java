package paasta.delivery.pipeline.scheduler.model;

/**
 * paastaDeliveryPipelineApi
 * paasta.delivery.pipeline.scheduler.model
 *
 * @author REX
 * @version 1.0
 * @since 9/7/2017
 */
public class CustomJob {

    // DATABASE COLUMNS
    private Long id;
    private String serviceInstancesId;
    private Long pipelineId;
    private String jobType;
    private String jobName;
    private String jobGuid;
    private int groupOrder;
    private int jobOrder;
    private String builderType;
    private Long buildJobId;
    private String jobTrigger;
    private String postActionYn;
    private String repositoryType;
    private String repositoryUrl;
    private String repositoryId;
    private String repositoryAccountId;
    private String repositoryAccountPassword;
    private String repositoryBranch;
    private String repositoryCommitRevision;
    private Long cfInfoId;
    private String appName;
    private String appUrl;
    private String deployType;
    private String blueGreenDeployStatus;
    private String deployTargetOrg;
    private String deployTargetSpace;
    private String manifestUseYn;
    private String manifestScript;
    private String inspectionProjectId;
    private String inspectionProfileId;
    private String inspectionGateId;
    private String userId;
    private String created;
    private String lastModified;

    // SUBQUERY COLUMNS
    private String buildJobName;
    private String lastJobStatus;
    private String lastJobModified;
    private int lastSuccessJobNumber;
    private int lastGroupOrder;
    private int lastJobNumber;

    // CI SERVER BUILD WITH DETAILS
    private long duration;
    private long estimatedDuration;
    private String consoleOutputHtml;
    private String isBuilding;
    private String isWorking;
    private String timeStamp;

    // FILE INFO
    private long fileId;
    private String buildFilePath;
    private String buildFileName;
    private String buildPackName;

    // UI
    private int jobNumber;
    private long jobHistoryId;
    private String newWorkGroupYn;
    private String triggerType;
    private String inspectionProjectName;
    private String inspectionProjectKey;

    private int previousJobNumber;
    private String schedulerModifiedPushYn;

    private String resultStatus;
    private String resultMessage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceInstancesId() {
        return serviceInstancesId;
    }

    public void setServiceInstancesId(String serviceInstancesId) {
        this.serviceInstancesId = serviceInstancesId;
    }

    public Long getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Long pipelineId) {
        this.pipelineId = pipelineId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGuid() {
        return jobGuid;
    }

    public void setJobGuid(String jobGuid) {
        this.jobGuid = jobGuid;
    }

    public int getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(int groupOrder) {
        this.groupOrder = groupOrder;
    }

    public int getJobOrder() {
        return jobOrder;
    }

    public void setJobOrder(int jobOrder) {
        this.jobOrder = jobOrder;
    }

    public String getBuilderType() {
        return builderType;
    }

    public void setBuilderType(String builderType) {
        this.builderType = builderType;
    }

    public Long getBuildJobId() {
        return buildJobId;
    }

    public void setBuildJobId(Long buildJobId) {
        this.buildJobId = buildJobId;
    }

    public String getJobTrigger() {
        return jobTrigger;
    }

    public void setJobTrigger(String jobTrigger) {
        this.jobTrigger = jobTrigger;
    }

    public String getPostActionYn() {
        return postActionYn;
    }

    public void setPostActionYn(String postActionYn) {
        this.postActionYn = postActionYn;
    }

    public String getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(String repositoryType) {
        this.repositoryType = repositoryType;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getRepositoryAccountId() {
        return repositoryAccountId;
    }

    public void setRepositoryAccountId(String repositoryAccountId) {
        this.repositoryAccountId = repositoryAccountId;
    }

    public String getRepositoryAccountPassword() {
        return repositoryAccountPassword;
    }

    public void setRepositoryAccountPassword(String repositoryAccountPassword) {
        this.repositoryAccountPassword = repositoryAccountPassword;
    }

    public String getRepositoryBranch() {
        return repositoryBranch;
    }

    public void setRepositoryBranch(String repositoryBranch) {
        this.repositoryBranch = repositoryBranch;
    }

    public String getRepositoryCommitRevision() {
        return repositoryCommitRevision;
    }

    public void setRepositoryCommitRevision(String repositoryCommitRevision) {
        this.repositoryCommitRevision = repositoryCommitRevision;
    }

    public Long getCfInfoId() {
        return cfInfoId;
    }

    public void setCfInfoId(Long cfInfoId) {
        this.cfInfoId = cfInfoId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getDeployType() {
        return deployType;
    }

    public void setDeployType(String deployType) {
        this.deployType = deployType;
    }

    public String getBlueGreenDeployStatus() {
        return blueGreenDeployStatus;
    }

    public void setBlueGreenDeployStatus(String blueGreenDeployStatus) {
        this.blueGreenDeployStatus = blueGreenDeployStatus;
    }

    public String getDeployTargetOrg() {
        return deployTargetOrg;
    }

    public void setDeployTargetOrg(String deployTargetOrg) {
        this.deployTargetOrg = deployTargetOrg;
    }

    public String getDeployTargetSpace() {
        return deployTargetSpace;
    }

    public void setDeployTargetSpace(String deployTargetSpace) {
        this.deployTargetSpace = deployTargetSpace;
    }

    public String getManifestUseYn() {
        return manifestUseYn;
    }

    public void setManifestUseYn(String manifestUseYn) {
        this.manifestUseYn = manifestUseYn;
    }

    public String getManifestScript() {
        return manifestScript;
    }

    public void setManifestScript(String manifestScript) {
        this.manifestScript = manifestScript;
    }

    public String getInspectionProjectId() {
        return inspectionProjectId;
    }

    public void setInspectionProjectId(String inspectionProjectId) {
        this.inspectionProjectId = inspectionProjectId;
    }

    public String getInspectionProfileId() {
        return inspectionProfileId;
    }

    public void setInspectionProfileId(String inspectionProfileId) {
        this.inspectionProfileId = inspectionProfileId;
    }

    public String getInspectionGateId() {
        return inspectionGateId;
    }

    public void setInspectionGateId(String inspectionGateId) {
        this.inspectionGateId = inspectionGateId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getBuildJobName() {
        return buildJobName;
    }

    public void setBuildJobName(String buildJobName) {
        this.buildJobName = buildJobName;
    }

    public String getLastJobStatus() {
        return lastJobStatus;
    }

    public void setLastJobStatus(String lastJobStatus) {
        this.lastJobStatus = lastJobStatus;
    }

    public String getLastJobModified() {
        return lastJobModified;
    }

    public void setLastJobModified(String lastJobModified) {
        this.lastJobModified = lastJobModified;
    }

    public int getLastSuccessJobNumber() {
        return lastSuccessJobNumber;
    }

    public void setLastSuccessJobNumber(int lastSuccessJobNumber) {
        this.lastSuccessJobNumber = lastSuccessJobNumber;
    }

    public int getLastGroupOrder() {
        return lastGroupOrder;
    }

    public void setLastGroupOrder(int lastGroupOrder) {
        this.lastGroupOrder = lastGroupOrder;
    }

    public int getLastJobNumber() {
        return lastJobNumber;
    }

    public void setLastJobNumber(int lastJobNumber) {
        this.lastJobNumber = lastJobNumber;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(long estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public String getConsoleOutputHtml() {
        return consoleOutputHtml;
    }

    public void setConsoleOutputHtml(String consoleOutputHtml) {
        this.consoleOutputHtml = consoleOutputHtml;
    }

    public String getIsBuilding() {
        return isBuilding;
    }

    public void setIsBuilding(String isBuilding) {
        this.isBuilding = isBuilding;
    }

    public String getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(String isWorking) {
        this.isWorking = isWorking;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getBuildFilePath() {
        return buildFilePath;
    }

    public void setBuildFilePath(String buildFilePath) {
        this.buildFilePath = buildFilePath;
    }

    public String getBuildFileName() {
        return buildFileName;
    }

    public void setBuildFileName(String buildFileName) {
        this.buildFileName = buildFileName;
    }

    public String getBuildPackName() {
        return buildPackName;
    }

    public void setBuildPackName(String buildPackName) {
        this.buildPackName = buildPackName;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(int jobNumber) {
        this.jobNumber = jobNumber;
    }

    public long getJobHistoryId() {
        return jobHistoryId;
    }

    public void setJobHistoryId(long jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public String getNewWorkGroupYn() {
        return newWorkGroupYn;
    }

    public void setNewWorkGroupYn(String newWorkGroupYn) {
        this.newWorkGroupYn = newWorkGroupYn;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public String getInspectionProjectName() {
        return inspectionProjectName;
    }

    public void setInspectionProjectName(String inspectionProjectName) {
        this.inspectionProjectName = inspectionProjectName;
    }

    public String getInspectionProjectKey() {
        return inspectionProjectKey;
    }

    public void setInspectionProjectKey(String inspectionProjectKey) {
        this.inspectionProjectKey = inspectionProjectKey;
    }

    public int getPreviousJobNumber() {
        return previousJobNumber;
    }

    public void setPreviousJobNumber(int previousJobNumber) {
        this.previousJobNumber = previousJobNumber;
    }

    public String getSchedulerModifiedPushYn() {
        return schedulerModifiedPushYn;
    }

    public void setSchedulerModifiedPushYn(String schedulerModifiedPushYn) {
        this.schedulerModifiedPushYn = schedulerModifiedPushYn;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "CustomJob{" +
                "id=" + id +
                ", serviceInstancesId='" + serviceInstancesId + '\'' +
                ", pipelineId=" + pipelineId +
                ", jobType='" + jobType + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGuid='" + jobGuid + '\'' +
                ", groupOrder=" + groupOrder +
                ", jobOrder=" + jobOrder +
                ", builderType='" + builderType + '\'' +
                ", buildJobId=" + buildJobId +
                ", jobTrigger='" + jobTrigger + '\'' +
                ", postActionYn='" + postActionYn + '\'' +
                ", repositoryType='" + repositoryType + '\'' +
                ", repositoryUrl='" + repositoryUrl + '\'' +
                ", repositoryId='" + repositoryId + '\'' +
                ", repositoryAccountId='" + repositoryAccountId + '\'' +
                ", repositoryBranch='" + repositoryBranch + '\'' +
                ", repositoryCommitRevision='" + repositoryCommitRevision + '\'' +
                ", cfInfoId=" + cfInfoId +
                ", appName='" + appName + '\'' +
                ", appUrl='" + appUrl + '\'' +
                ", deployType='" + deployType + '\'' +
                ", blueGreenDeployStatus='" + blueGreenDeployStatus + '\'' +
                ", deployTargetOrg='" + deployTargetOrg + '\'' +
                ", deployTargetSpace='" + deployTargetSpace + '\'' +
                ", manifestUseYn='" + manifestUseYn + '\'' +
                ", manifestScript='" + manifestScript + '\'' +
                ", inspectionProjectId='" + inspectionProjectId + '\'' +
                ", inspectionProfileId='" + inspectionProfileId + '\'' +
                ", inspectionGateId='" + inspectionGateId + '\'' +
                ", userId='" + userId + '\'' +
                ", created='" + created + '\'' +
                ", lastModified='" + lastModified + '\'' +
                ", buildJobName='" + buildJobName + '\'' +
                ", lastJobStatus='" + lastJobStatus + '\'' +
                ", lastJobModified='" + lastJobModified + '\'' +
                ", lastSuccessJobNumber=" + lastSuccessJobNumber +
                ", lastGroupOrder=" + lastGroupOrder +
                ", lastJobNumber=" + lastJobNumber +
                ", duration=" + duration +
                ", estimatedDuration=" + estimatedDuration +
                ", consoleOutputHtml='" + consoleOutputHtml + '\'' +
                ", isBuilding='" + isBuilding + '\'' +
                ", isWorking='" + isWorking + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", fileId=" + fileId +
                ", buildFilePath='" + buildFilePath + '\'' +
                ", buildFileName='" + buildFileName + '\'' +
                ", buildPackName='" + buildPackName + '\'' +
                ", jobNumber=" + jobNumber +
                ", jobHistoryId=" + jobHistoryId +
                ", newWorkGroupYn='" + newWorkGroupYn + '\'' +
                ", triggerType='" + triggerType + '\'' +
                ", inspectionProjectName='" + inspectionProjectName + '\'' +
                ", inspectionProjectKey='" + inspectionProjectKey + '\'' +
                ", previousJobNumber=" + previousJobNumber +
                ", schedulerModifiedPushYn='" + schedulerModifiedPushYn + '\'' +
                ", resultStatus='" + resultStatus + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }

}
