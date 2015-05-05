package riley.web.rest.workflow;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;
import java.util.Date;

/**
 * The persistent class for the workflow_form_instance database table.
 * 
 */
@UuidGenerator(name="UUID")
@XmlRootElement
@Entity
@Table(name="workflow_form_instance")
@NamedQuery(name="WorkflowFormInstance.findAll", query="SELECT w FROM WorkflowFormInstance w")
public class WorkflowFormInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="form_instance_id")
	@GeneratedValue(generator="UUID")
	private String formInstanceId;

	@Column(name="form_data")
	private String formData;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="submitted_on")
	private Date submittedOn;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="submitted_by")
	private User user;

	//bi-directional many-to-one association to WorkflowInstance
	@ManyToOne
	@JoinColumn(name="workflow_instance_id")
	private WorkflowInstance workflowInstance;

	//bi-directional many-to-one association to WorkflowForm
	@ManyToOne
	@JoinColumn(name="form_id")
	private WorkflowForm workflowForm;

	public WorkflowFormInstance() {
	}

	public String getFormInstanceId() {
		return this.formInstanceId;
	}

	public void setFormInstanceId(String formInstanceId) {
		this.formInstanceId = formInstanceId;
	}

	public String getFormData() {
		return this.formData;
	}

	public void setFormData(String formData) {
		this.formData = formData;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSubmittedOn() {
		return this.submittedOn;
	}

	public void setSubmittedOn(Date submittedOn) {
		this.submittedOn = submittedOn;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public WorkflowInstance getWorkflowInstance() {
		return this.workflowInstance;
	}

	public void setWorkflowInstance(WorkflowInstance workflowInstance) {
		this.workflowInstance = workflowInstance;
	}

	public WorkflowForm getWorkflowForm() {
		return this.workflowForm;
	}

	public void setWorkflowForm(WorkflowForm workflowForm) {
		this.workflowForm = workflowForm;
	}

}