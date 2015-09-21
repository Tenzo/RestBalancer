from locust import HttpLocust, TaskSet, task

class GetGroup(TaskSet):

    @task
    def group(self):
        for i in range(1000000):
	    with self.client.get("/group?userId=user%i" % i, name="/group?userId=[userId]", catch_response=True) as response:
		    if response.status_code == 201:
			response.failure("User " + str(i) + " created with group " + response.content)

class WebsiteUser(HttpLocust):
    task_set = GetGroup
    min_wait=5000
    max_wait=9000
