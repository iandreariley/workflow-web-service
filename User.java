package riley.web.rest.workflow;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@XmlRootElement
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="user_type")
	private String userType;

	//bi-directional many-to-one association to Workflow
	@OneToMany(mappedBy="user1")
	private List<Workflow> workflows1;

	//bi-directional many-to-one association to Workflow
	@OneToMany(mappedBy="user2")
	private List<Workflow> workflows2;

	//bi-directional many-to-one association to WorkflowForm
	@OneToMany(mappedBy="user1")
	private List<WorkflowForm> workflowForms1;

	//bi-directional many-to-one association to WorkflowForm
	@OneToMany(mappedBy="user2")
	private List<WorkflowForm> workflowForms2;

	//bi-directional many-to-one association to WorkflowFormInstance
	@OneToMany(mappedBy="user")
	private List<WorkflowFormInstance> workflowFormInstances;

	//bi-directional many-to-one association to WorkflowInstance
	@OneToMany(mappedBy="user")
	private List<WorkflowInstance> workflowInstances;

	//bi-directional many-to-one association to WorkflowInstanceLog
	@OneToMany(mappedBy="user")
	private List<WorkflowInstanceLog> workflowInstanceLogs;

	public User() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<Workflow> getWorkflows1() {
		return this.workflows1;
	}

	public void setWorkflows1(List<Workflow> workflows1) {
		this.workflows1 = workflows1;
	}

	public Workflow addWorkflows1(Workflow workflows1) {
		getWorkflows1().add(workflows1);
		workflows1.setUser1(this);

		return workflows1;
	}

	public Workflow removeWorkflows1(Workflow workflows1) {
		getWorkflows1().remove(workflows1);
		workflows1.setUser1(null);

		return workflows1;
	}

	public List<Workflow> getWorkflows2() {
		return this.workflows2;
	}

	public void setWorkflows2(List<Workflow> workflows2) {
		this.workflows2 = workflows2;
	}

	public Workflow addWorkflows2(Workflow workflows2) {
		getWorkflows2().add(workflows2);
		workflows2.setUser2(this);

		return workflows2;
	}

	public Workflow removeWorkflows2(Workflow workflows2) {
		getWorkflows2().remove(workflows2);
		workflows2.setUser2(null);

		return workflows2;
	}

	public List<WorkflowForm> getWorkflowForms1() {
		return this.workflowForms1;
	}

	public void setWorkflowForms1(List<WorkflowForm> workflowForms1) {
		this.workflowForms1 = workflowForms1;
	}

	public WorkflowForm addWorkflowForms1(WorkflowForm workflowForms1) {
		getWorkflowForms1().add(workflowForms1);
		workflowForms1.setUser1(this);

		return workflowForms1;
	}

	public WorkflowForm removeWorkflowForms1(WorkflowForm workflowForms1) {
		getWorkflowForms1().remove(workflowForms1);
		workflowForms1.setUser1(null);

		return workflowForms1;
	}

	public List<WorkflowForm> getWorkflowForms2() {
		return this.workflowForms2;
	}

	public void setWorkflowForms2(List<WorkflowForm> workflowForms2) {
		this.workflowForms2 = workflowForms2;
	}

	public WorkflowForm addWorkflowForms2(WorkflowForm workflowForms2) {
		getWorkflowForms2().add(workflowForms2);
		workflowForms2.setUser2(this);

		return workflowForms2;
	}

	public WorkflowForm removeWorkflowForms2(WorkflowForm workflowForms2) {
		getWorkflowForms2().remove(workflowForms2);
		workflowForms2.setUser2(null);

		return workflowForms2;
	}

	public List<WorkflowFormInstance> getWorkflowFormInstances() {
		return this.workflowFormInstances;
	}

	public void setWorkflowFormInstances(List<WorkflowFormInstance> workflowFormInstances) {
		this.workflowFormInstances = workflowFormInstances;
	}

	public WorkflowFormInstance addWorkflowFormInstance(WorkflowFormInstance workflowFormInstance) {
		getWorkflowFormInstances().add(workflowFormInstance);
		workflowFormInstance.setUser(this);

		return workflowFormInstance;
	}

	public WorkflowFormInstance removeWorkflowFormInstance(WorkflowFormInstance workflowFormInstance) {
		getWorkflowFormInstances().remove(workflowFormInstance);
		workflowFormInstance.setUser(null);

		return workflowFormInstance;
	}

	public List<WorkflowInstance> getWorkflowInstances() {
		return this.workflowInstances;
	}

	public void setWorkflowInstances(List<WorkflowInstance> workflowInstances) {
		this.workflowInstances = workflowInstances;
	}

	public WorkflowInstance addWorkflowInstance(WorkflowInstance workflowInstance) {
		getWorkflowInstances().add(workflowInstance);
		workflowInstance.setUser(this);

		return workflowInstance;
	}

	public WorkflowInstance removeWorkflowInstance(WorkflowInstance workflowInstance) {
		getWorkflowInstances().remove(workflowInstance);
		workflowInstance.setUser(null);

		return workflowInstance;
	}

	public List<WorkflowInstanceLog> getWorkflowInstanceLogs() {
		return this.workflowInstanceLogs;
	}

	public void setWorkflowInstanceLogs(List<WorkflowInstanceLog> workflowInstanceLogs) {
		this.workflowInstanceLogs = workflowInstanceLogs;
	}

	public WorkflowInstanceLog addWorkflowInstanceLog(WorkflowInstanceLog workflowInstanceLog) {
		getWorkflowInstanceLogs().add(workflowInstanceLog);
		workflowInstanceLog.setUser(this);

		return workflowInstanceLog;
	}

	public WorkflowInstanceLog removeWorkflowInstanceLog(WorkflowInstanceLog workflowInstanceLog) {
		getWorkflowInstanceLogs().remove(workflowInstanceLog);
		workflowInstanceLog.setUser(null);

		return workflowInstanceLog;
	}

}