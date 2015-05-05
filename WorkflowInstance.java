package riley.web.rest.workflow;

import java.io.Serializable;
import org.eclipse.persistence.annotations.UuidGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the workflow_instance database table.
 * 
 */
@UuidGenerator(name="UUID")
@XmlRootElement
@Entity
@Table(name="workflow_instance")
@NamedQuery(name="WorkflowInstance.findAll", query="SELECT w FROM WorkflowInstance w")
public class WorkflowInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="workflow_instance_id")
	@GeneratedValue(generator="UUID")
	private String workflowInstanceId;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="submtted_on")
	private Date submttedOn;

	@Column(name="workflow_data")
	private String workflowData;

	//bi-directional many-to-one association to WorkflowFormInstance
	@OneToMany(mappedBy="workflowInstance")
	private List<WorkflowFormInstance> workflowFormInstances;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="submitted_by")
	private User user;

	//bi-directional many-to-one association to Workflow
	@ManyToOne
	@JoinColumn(name="workflow_id")
	private Workflow workflow;

	//bi-directional many-to-one association to WorkflowInstanceLog
	@OneToMany(mappedBy="workflowInstance")
	private List<WorkflowInstanceLog> workflowInstanceLogs;

	public WorkflowInstance() {
	}

	public String getWorkflowInstanceId() {
		return this.workflowInstanceId;
	}

	public void setWorkflowInstanceId(String workflowInstanceId) {
		this.workflowInstanceId = workflowInstanceId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmttedOn() {
		return this.submttedOn;
	}

	public void setSubmttedOn(Date submttedOn) {
		this.submttedOn = submttedOn;
	}

	public String getWorkflowData() {
		return this.workflowData;
	}

	public void setWorkflowData(String workflowData) {
		this.workflowData = workflowData;
	}

	public List<WorkflowFormInstance> getWorkflowFormInstances() {
		return this.workflowFormInstances;
	}

	public void setWorkflowFormInstances(List<WorkflowFormInstance> workflowFormInstances) {
		this.workflowFormInstances = workflowFormInstances;
	}

	public WorkflowFormInstance addWorkflowFormInstance(WorkflowFormInstance workflowFormInstance) {
		getWorkflowFormInstances().add(workflowFormInstance);
		workflowFormInstance.setWorkflowInstance(this);

		return workflowFormInstance;
	}

	public WorkflowFormInstance removeWorkflowFormInstance(WorkflowFormInstance workflowFormInstance) {
		getWorkflowFormInstances().remove(workflowFormInstance);
		workflowFormInstance.setWorkflowInstance(null);

		return workflowFormInstance;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public List<WorkflowInstanceLog> getWorkflowInstanceLogs() {
		return this.workflowInstanceLogs;
	}

	public void setWorkflowInstanceLogs(List<WorkflowInstanceLog> workflowInstanceLogs) {
		this.workflowInstanceLogs = workflowInstanceLogs;
	}

	public WorkflowInstanceLog addWorkflowInstanceLog(WorkflowInstanceLog workflowInstanceLog) {
		getWorkflowInstanceLogs().add(workflowInstanceLog);
		workflowInstanceLog.setWorkflowInstance(this);

		return workflowInstanceLog;
	}

	public WorkflowInstanceLog removeWorkflowInstanceLog(WorkflowInstanceLog workflowInstanceLog) {
		getWorkflowInstanceLogs().remove(workflowInstanceLog);
		workflowInstanceLog.setWorkflowInstance(null);

		return workflowInstanceLog;
	}

}