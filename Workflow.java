package riley.web.rest.workflow;

import java.io.Serializable;
import org.eclipse.persistence.annotations.UuidGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the workflow database table.
 * 
 */
@UuidGenerator(name="UUID")
@XmlRootElement
@Entity
@Table(name="workflow")
@NamedQuery(name="Workflow.findAll", query="SELECT w FROM Workflow w")
public class Workflow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator(name="UUID")
	@Column(name="workflow_id")
	private String workflowId;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_on")
	private Date createOn;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String name;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_by")
	private User user2;

	//bi-directional many-to-one association to WorkflowForm
	@OneToMany(mappedBy="workflow")
	private List<WorkflowForm> workflowForms;

	//bi-directional many-to-one association to WorkflowInstance
	@OneToMany(mappedBy="workflow")
	private List<WorkflowInstance> workflowInstances;

	public Workflow() {
	}

	public String getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateOn() {
		return this.createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public List<WorkflowForm> getWorkflowForms() {
		return this.workflowForms;
	}

	public void setWorkflowForms(List<WorkflowForm> workflowForms) {
		this.workflowForms = workflowForms;
	}

	public WorkflowForm addWorkflowForm(WorkflowForm workflowForm) {
		getWorkflowForms().add(workflowForm);
		workflowForm.setWorkflow(this);

		return workflowForm;
	}

	public WorkflowForm removeWorkflowForm(WorkflowForm workflowForm) {
		getWorkflowForms().remove(workflowForm);
		workflowForm.setWorkflow(null);

		return workflowForm;
	}

	public List<WorkflowInstance> getWorkflowInstances() {
		return this.workflowInstances;
	}

	public void setWorkflowInstances(List<WorkflowInstance> workflowInstances) {
		this.workflowInstances = workflowInstances;
	}

	public WorkflowInstance addWorkflowInstance(WorkflowInstance workflowInstance) {
		getWorkflowInstances().add(workflowInstance);
		workflowInstance.setWorkflow(this);

		return workflowInstance;
	}

	public WorkflowInstance removeWorkflowInstance(WorkflowInstance workflowInstance) {
		getWorkflowInstances().remove(workflowInstance);
		workflowInstance.setWorkflow(null);

		return workflowInstance;
	}

}