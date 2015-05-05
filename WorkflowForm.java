package riley.web.rest.workflow;

import java.io.Serializable;
import org.eclipse.persistence.annotations.UuidGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the workflow_form database table.
 * 
 */
@UuidGenerator(name="UUID")
@Entity
@Table(name="workflow_form")
@NamedQuery(name="WorkflowForm.findAll", query="SELECT w FROM WorkflowForm w")
public class WorkflowForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="form_id")
	@GeneratedValue(generator = "UUID")
	private String formId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	private String description;

	@Column(name="is_published")
	private boolean isPublished;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	//bi-directional many-to-one association to Workflow
	@ManyToOne
	@JoinColumn(name="workflow_id")
	private Workflow workflow;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_by")
	private User user2;

	//bi-directional many-to-one association to WorkflowFormInstance
	@OneToMany(mappedBy="workflowForm")
	private List<WorkflowFormInstance> workflowFormInstances;

	public WorkflowForm() {
	}

	public String getFormId() {
		return this.formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getIsPublished() {
		return this.isPublished;
	}

	public void setIsPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Workflow getWorkflow() {
		return this.workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
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

	public List<WorkflowFormInstance> getWorkflowFormInstances() {
		return this.workflowFormInstances;
	}

	public void setWorkflowFormInstances(List<WorkflowFormInstance> workflowFormInstances) {
		this.workflowFormInstances = workflowFormInstances;
	}

	public WorkflowFormInstance addWorkflowFormInstance(WorkflowFormInstance workflowFormInstance) {
		getWorkflowFormInstances().add(workflowFormInstance);
		workflowFormInstance.setWorkflowForm(this);

		return workflowFormInstance;
	}

	public WorkflowFormInstance removeWorkflowFormInstance(WorkflowFormInstance workflowFormInstance) {
		getWorkflowFormInstances().remove(workflowFormInstance);
		workflowFormInstance.setWorkflowForm(null);

		return workflowFormInstance;
	}

}