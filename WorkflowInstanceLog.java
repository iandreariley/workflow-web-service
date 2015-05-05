package riley.web.rest.workflow;

import java.io.Serializable;
import org.eclipse.persistence.annotations.UuidGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the workflow_instance_log database table.
 * 
 */
@UuidGenerator(name="UUID")
@XmlRootElement
@Entity
@Table(name="workflow_instance_log")
@NamedQuery(name="WorkflowInstanceLog.findAll", query="SELECT w FROM WorkflowInstanceLog w")
public class WorkflowInstanceLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="log_id")
	@GeneratedValue(generator="UUID")
	private String logId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="action_on")
	private Date actionOn;

	private String description;

	//bi-directional many-to-one association to WorkflowInstance
	@ManyToOne
	@JoinColumn(name="workflow_instance_id")
	private WorkflowInstance workflowInstance;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="action_by")
	private User user;

	public WorkflowInstanceLog() {
	}

	public String getLogId() {
		return this.logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public Date getActionOn() {
		return this.actionOn;
	}

	public void setActionOn(Date actionOn) {
		this.actionOn = actionOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WorkflowInstance getWorkflowInstance() {
		return this.workflowInstance;
	}

	public void setWorkflowInstance(WorkflowInstance workflowInstance) {
		this.workflowInstance = workflowInstance;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}