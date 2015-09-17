from locust import HttpLocust, TaskSet, task

counter = 0

class GetGroup(TaskSet):
    global counter

    def on_start(self):
        counter = 0

    @task
    def group(self):
        for i in range(1000000):
            self.client.get("/group?userId=user%i" % i, name="/group?userId=[userId]")

class WebsiteUser(HttpLocust):
    task_set = GetGroup
    min_wait=5000
    max_wait=9000
