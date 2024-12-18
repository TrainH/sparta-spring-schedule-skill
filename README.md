# 일정 관리 API

##  개요
이 프로그램은 사용자의 일정을 체계적으로 관리할 수 있도록 설계된 일정 관리 API 서버입니다. 

일정 관리 API는 일정 관리를 위해 일정 생성, 전체 및 조건 조회, 삭제를 할 수 있습니다.

그리고 예외 처리 기능을 통해 안정성을 제공합니다.

>
> 
> **일정 관리 앱을 구현하기 위해 IntelliJ에서 Spring으로 만들어진 기본 프로젝트입니다.**
> 
> **작성자:** TrainH
> 
> **개발 기간:** 2024년 11월 29일 ~ 12월 11일  
>
> **개발 환경:**
> - **IDE**: IntelliJ IDEA
> - **프레임워크**: Spring Boot
> - **DB**: My Sql Database
[spring-schedule-skill.postman_collection.json](https://github.com/user-attachments/files/18179916/spring-schedule-skill.postman_collection.json)
{
	"info": {
		"_postman_id": "14126cc4-4356-4f4b-afd7-1c223467866d",
		"name": "spring-schedule-skill",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "30208126"
	},
	"item": [
		{
			"name": "schedule",
			"item": [
				{
					"name": "등록",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"userName\": \"user\",\r\n    \"todoTitle\": \"todoTitle\",\r\n    \"todoContent\": \"todoContent\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/schedules",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"schedules"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user2\",\r\n    \"todoTitle\": \"todoTitle2\",\r\n    \"todoContent\": \"todoContent2\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/schedules",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:21:00 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 1,\n    \"userName\": \"user2\",\n    \"todoTitle\": \"todoTitle2\",\n    \"todoContent\": \"todoContent2\",\n    \"created\": \"2024-12-18T17:21:00.3894519\",\n    \"modified\": \"2024-12-18T17:21:00.3894519\"\n}"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user2\",\r\n    \"todoTitle\": \"todoTitle2_1\",\r\n    \"todoContent\": \"todoContent2_1\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/schedules",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:03:58 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:03:58.316+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/schedules\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user\",\r\n    \"todoTitle\": \"todoTitle\",\r\n    \"todoContent\": \"todoContent\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/schedules",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:21:36 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:21:36.890+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/schedules\"\n}"
						}
					]
				},
				{
					"name": "조회",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/schedules",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"schedules"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:23:49 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "[\n    {\n        \"id\": 1,\n        \"userName\": \"user2\",\n        \"todoTitle\": \"todoTitle2\",\n        \"todoContent\": \"todoContent2\",\n        \"created\": \"2024-12-18T17:21:00\",\n        \"modified\": \"2024-12-18T17:21:00\"\n    }\n]"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:03:18 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:03:18.031+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/schedules\"\n}"
						}
					]
				},
				{
					"name": "페이지 조회",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/schedules/list?page=0",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"schedules",
								"list"
							],
							"query": [
								{
									"key": "page",
									"value": "0"
								}
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules/list?page=0",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"list"
									],
									"query": [
										{
											"key": "page",
											"value": "0"
										}
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:16:37 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"content\": [\n        {\n            \"id\": 7,\n            \"userName\": \"user\",\n            \"todoTitle\": \"todoTitle2\",\n            \"todoContent\": \"todoContent2\",\n            \"numOfComments\": 0,\n            \"created\": \"2024-12-18T19:14:01\",\n            \"modified\": \"2024-12-18T19:14:01\"\n        },\n        {\n            \"id\": 6,\n            \"userName\": \"user\",\n            \"todoTitle\": \"todoTitle\",\n            \"todoContent\": \"todoContent\",\n            \"numOfComments\": 0,\n            \"created\": \"2024-12-18T19:13:49\",\n            \"modified\": \"2024-12-18T19:13:49\"\n        },\n        {\n            \"id\": 5,\n            \"userName\": \"user2\",\n            \"todoTitle\": \"todoTitle2\",\n            \"todoContent\": \"todoContent2\",\n            \"numOfComments\": 0,\n            \"created\": \"2024-12-18T19:13:29\",\n            \"modified\": \"2024-12-18T19:13:29\"\n        },\n        {\n            \"id\": 4,\n            \"userName\": \"user2\",\n            \"todoTitle\": \"todoTitle2\",\n            \"todoContent\": \"todoContent2\",\n            \"numOfComments\": 0,\n            \"created\": \"2024-12-18T19:13:24\",\n            \"modified\": \"2024-12-18T19:13:24\"\n        },\n        {\n            \"id\": 3,\n            \"userName\": \"user2\",\n            \"todoTitle\": \"todoTitle2\",\n            \"todoContent\": \"todoContent2\",\n            \"numOfComments\": 0,\n            \"created\": \"2024-12-18T19:13:21\",\n            \"modified\": \"2024-12-18T19:13:21\"\n        },\n        {\n            \"id\": 2,\n            \"userName\": \"user2\",\n            \"todoTitle\": \"todoTitle2\",\n            \"todoContent\": \"todoContent2\",\n            \"numOfComments\": 2,\n            \"created\": \"2024-12-18T19:13:18\",\n            \"modified\": \"2024-12-18T19:13:18\"\n        },\n        {\n            \"id\": 1,\n            \"userName\": \"user2\",\n            \"todoTitle\": \"todoTitle2\",\n            \"todoContent\": \"todoContent2\",\n            \"numOfComments\": 5,\n            \"created\": \"2024-12-18T19:13:09\",\n            \"modified\": \"2024-12-18T19:13:09\"\n        }\n    ],\n    \"pageable\": {\n        \"pageNumber\": 0,\n        \"pageSize\": 10,\n        \"sort\": {\n            \"empty\": false,\n            \"sorted\": true,\n            \"unsorted\": false\n        },\n        \"offset\": 0,\n        \"paged\": true,\n        \"unpaged\": false\n    },\n    \"last\": true,\n    \"totalPages\": 1,\n    \"totalElements\": 7,\n    \"first\": true,\n    \"size\": 10,\n    \"number\": 0,\n    \"sort\": {\n        \"empty\": false,\n        \"sorted\": true,\n        \"unsorted\": false\n    },\n    \"numberOfElements\": 7,\n    \"empty\": false\n}"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules/list?page=1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"list"
									],
									"query": [
										{
											"key": "page",
											"value": "1"
										}
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:04:51 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:04:51.141+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/schedules/list\"\n}"
						}
					]
				},
				{
					"name": "단건 조회",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/schedules/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"schedules",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"1"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:18:08 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 1,\n    \"userName\": \"user2\",\n    \"todoTitle\": \"todoTitle2\",\n    \"todoContent\": \"todoContent2\",\n    \"created\": \"2024-12-18T19:13:09\",\n    \"modified\": \"2024-12-18T19:13:09\"\n}"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"1"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:05:27 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:05:27.589+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/schedules/1\"\n}"
						}
					]
				},
				{
					"name": "수정",
					"request": {
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"todoTitle\": \"todoTitle11\",\r\n    \"todoContent\": \"todoContent11\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/schedules/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"schedules",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"todoTitle\": \"todoTitle11\",\r\n    \"todoContent\": \"todoContent11\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/schedules/6",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"6"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:19:51 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"todoTitle\": \"todoTitle11\",\r\n    \"todoContent\": \"todoContent11\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/schedules/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"1"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:06:07 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:06:07.708+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/schedules/1\"\n}"
						}
					]
				},
				{
					"name": "삭제",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/schedules/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"schedules",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"1"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:21:06 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/schedules/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"schedules",
										"1"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:07:19 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:07:19.864+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/schedules/1\"\n}"
						}
					]
				}
			]
		},
		{
			"name": "member",
			"item": [
				{
					"name": "등록",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"userName\": \"user2\",\r\n    \"email\": \"user2@example.com\",\r\n    \"password\": \"1234\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/members/signup",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"members",
								"signup"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user2\",\r\n    \"email\": \"user2@example.com\",\r\n    \"password\": \"1234\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/members/signup",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"signup"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 07:34:59 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 1,\n    \"userName\": \"user\",\n    \"email\": \"user@example.com\",\n    \"createdAt\": \"2024-12-18T16:34:59.0204766\"\n}"
						},
						{
							"name": "400",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"use\",\r\n    \"email\": \"use@example.com\",\r\n    \"password\": \"1234\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/members/signup",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"signup"
									]
								}
							},
							"status": "Bad Request",
							"code": 400,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:00:19 GMT"
								},
								{
									"key": "Connection",
									"value": "close"
								}
							],
							"cookie": [],
							"body": "[\n    \"userName: userName must be 4~10 characters.\"\n]"
						},
						{
							"name": "400",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user\",\r\n    \"email\": \"userexample.com\",\r\n    \"password\": \"1234\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/members/signup",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"signup"
									]
								}
							},
							"status": "Bad Request",
							"code": 400,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:17:44 GMT"
								},
								{
									"key": "Connection",
									"value": "close"
								}
							],
							"cookie": [],
							"body": "[\n    \"email: Email should be in a valid format (e.g., user@example.com).\"\n]"
						}
					]
				},
				{
					"name": "조회",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/members",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"members"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:11:02 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "[\n    {\n        \"id\": 1,\n        \"userName\": \"user\",\n        \"email\": \"user@example.com\",\n        \"createdAt\": \"2024-12-18T17:08:27\"\n    },\n    {\n        \"id\": 2,\n        \"userName\": \"user2\",\n        \"email\": \"user2@example.com\",\n        \"createdAt\": \"2024-12-18T17:09:32\"\n    }\n]"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:01:21 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:01:21.838+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/members\"\n}"
						}
					]
				},
				{
					"name": "단건 조회",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/members/2",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"members",
								"2"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"1"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:11:44 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 1,\n    \"userName\": \"user\",\n    \"email\": \"user@example.com\",\n    \"createdAt\": \"2024-12-18T17:08:27\"\n}"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"1"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:09:47 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:09:47.732+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/members/1\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members/5",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"5"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:16:19 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:16:19.663+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/members/5\"\n}"
						}
					]
				},
				{
					"name": "수정",
					"request": {
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"userName\": \"user\",\r\n    \"password\":\"123456\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/members/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"members",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user\",\r\n    \"password\":\"12345\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/members/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"1"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:12:44 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user\",\r\n    \"password\":\"123456\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/members/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"1"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:18:59 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:18:59.174+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/members/1\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"userName\": \"user\",\r\n    \"password\":\"12345\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/members/3",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"3"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:13:23 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:13:23.111+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/members/3\"\n}"
						}
					]
				},
				{
					"name": "삭제",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/members/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"members",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"1"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:14:19 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members/2",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"2"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:19:24 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:19:24.966+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/members/2\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/members/4",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"members",
										"4"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:15:43 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:15:43.727+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/members/4\"\n}"
						}
					]
				}
			]
		},
		{
			"name": "login",
			"item": [
				{
					"name": "login",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"email\":\"user@example.com\",\r\n    \"password\":\"1234\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/auth/login",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"auth",
								"login"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"email\":\"user@example.com\",\r\n    \"password\":\"1234\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/auth/login",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"auth",
										"login"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Set-Cookie",
									"value": "SESSION=3869a951-564d-4fb0-b12d-af0b9d381648; Max-Age=3600; Expires=Wed, 18 Dec 2024 09:02:12 GMT; Path=/; HttpOnly"
								},
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:02:12 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"message\": \"Login succeessful\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"email\":\"user2@example.com\",\r\n    \"password\":\"12345\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/auth/login",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"auth",
										"login"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:04:22 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T08:04:21.999+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/auth/login\"\n}"
						}
					]
				},
				{
					"name": "logout",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/auth/logout",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"auth",
								"logout"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/auth/logout",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"auth",
										"logout"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Set-Cookie",
									"value": "SESSION=; Max-Age=0; Expires=Thu, 01 Jan 1970 00:00:10 GMT; Path=/; HttpOnly"
								},
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 08:08:58 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"message\": \"Logout completed\"\n}"
						}
					]
				}
			]
		},
		{
			"name": "Comment",
			"item": [
				{
					"name": "등록",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"schedule_id\" : 3,\r\n    \"comment\" : \"comment1\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/comments",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comments"
							]
						}
					},
					"response": [
						{
							"name": "401",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"schedule_id\" : 3,\r\n    \"comment\" : \"comment1\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/comments",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:07:59 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:07:59.712+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/comments\"\n}"
						},
						{
							"name": "200",
							"originalRequest": {
								"method": "POST",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"schedule_id\" : 3,\r\n    \"comment\" : \"comment1\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/comments",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:22:03 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 8,\n    \"schedule_id\": 3,\n    \"comment\": \"comment1\",\n    \"created\": \"2024-12-18T19:22:03.3562184\",\n    \"modified\": \"2024-12-18T19:22:03.3562184\"\n}"
						}
					]
				},
				{
					"name": "조회",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/comments",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comments"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:22:44 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "[\n    {\n        \"id\": 6,\n        \"schedule_id\": 2,\n        \"comment\": \"comment21\",\n        \"created\": \"2024-12-18T19:16:13\",\n        \"modified\": \"2024-12-18T19:16:13\"\n    },\n    {\n        \"id\": 7,\n        \"schedule_id\": 2,\n        \"comment\": \"comment22\",\n        \"created\": \"2024-12-18T19:16:19\",\n        \"modified\": \"2024-12-18T19:16:19\"\n    },\n    {\n        \"id\": 8,\n        \"schedule_id\": 3,\n        \"comment\": \"comment1\",\n        \"created\": \"2024-12-18T19:22:03\",\n        \"modified\": \"2024-12-18T19:22:03\"\n    }\n]"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:08:25 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:08:25.950+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/comments\"\n}"
						}
					]
				},
				{
					"name": "단건 조회",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/comments/2",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comments",
								"2"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments/6",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"6"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:24:38 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"id\": 6,\n    \"schedule_id\": 2,\n    \"comment\": \"comment21\",\n    \"created\": \"2024-12-18T19:16:13\",\n    \"modified\": \"2024-12-18T19:16:13\"\n}"
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments/2",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"2"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:08:54 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:08:54.183+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/comments/2\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "GET",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments/2",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"2"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:23:32 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:23:32.104+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/comments/2\"\n}"
						}
					]
				},
				{
					"name": "수정",
					"request": {
						"method": "PATCH",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"comment\": \"comment66\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/comments/6",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comments",
								"6"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"comment\": \"comment66\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/comments/6",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"6"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:25:43 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"comment\": \"helsdflo\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/comments/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"1"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:09:26 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:09:26.019+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/comments/1\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "PATCH",
								"header": [],
								"body": {
									"mode": "raw",
									"raw": "{\r\n    \"comment\": \"comment99\"\r\n}",
									"options": {
										"raw": {
											"language": "json"
										}
									}
								},
								"url": {
									"raw": "http://localhost:8080/comments/9",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"9"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:26:57 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:26:57.529+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/comments/9\"\n}"
						}
					]
				},
				{
					"name": "삭제",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/comments/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"comments",
								"1"
							]
						}
					},
					"response": [
						{
							"name": "200",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments/6",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"6"
									]
								}
							},
							"status": "OK",
							"code": 200,
							"_postman_previewlanguage": "plain",
							"header": [
								{
									"key": "Content-Length",
									"value": "0"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:27:52 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": null
						},
						{
							"name": "401",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments/1",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"1"
									]
								}
							},
							"status": "Unauthorized",
							"code": 401,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:09:59 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:09:59.946+00:00\",\n    \"status\": 401,\n    \"error\": \"Unauthorized\",\n    \"path\": \"/comments/1\"\n}"
						},
						{
							"name": "404",
							"originalRequest": {
								"method": "DELETE",
								"header": [],
								"url": {
									"raw": "http://localhost:8080/comments/9",
									"protocol": "http",
									"host": [
										"localhost"
									],
									"port": "8080",
									"path": [
										"comments",
										"9"
									]
								}
							},
							"status": "Not Found",
							"code": 404,
							"_postman_previewlanguage": "json",
							"header": [
								{
									"key": "Content-Type",
									"value": "application/json"
								},
								{
									"key": "Transfer-Encoding",
									"value": "chunked"
								},
								{
									"key": "Date",
									"value": "Wed, 18 Dec 2024 10:28:39 GMT"
								},
								{
									"key": "Keep-Alive",
									"value": "timeout=60"
								},
								{
									"key": "Connection",
									"value": "keep-alive"
								}
							],
							"cookie": [],
							"body": "{\n    \"timestamp\": \"2024-12-18T10:28:39.882+00:00\",\n    \"status\": 404,\n    \"error\": \"Not Found\",\n    \"path\": \"/comments/9\"\n}"
						}
					]
				}
			]
		}
	]
}
