<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>">
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
	<link href="html/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="html/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="html/assets/css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/>
	<link rel="stylesheet" href="html/iconfont/iconfont.css">
</head>
<div id="setting" style="padding-top: 1em">
	<div class="container-fluid">

					
						<div class="row">
								<div class="col-xl-12">
										<div class="breadcrumb-holder">
												<h1 class="main-title float-left">个人信息</h1>
												<ol class="breadcrumb float-right">
													
													<li class="breadcrumb-item active">设置</li>
												</ol>
												<div class="clearfix"></div>
										</div>
								</div>
						</div>
						<!-- end row -->

            
						<div class="alert alert-danger" role="alert">
						<h4 class="alert-heading">Important!</h4>
						<p>This section is available in Pike Admin PRO version.</p>
						<p><b>Save over 50 hours of development with our Pro Framework: Registration / Login / Users Management, CMS, Front-End Template (who will load contend added in admin area and saved in MySQL database), Contact Messages Management, manage Website Settings and many more, at an incredible price!</b></p>
						<p>Read more about all PRO features here: <a target="_blank" href="#"><b>Pike Admin PRO features</b></a></p>
						</div>

							
							
						<div class="row">
							
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">						
										<div class="card mb-3">
											<div class="card-header">
												<h3><i class="fa fa-user"></i> 详细 设置 </h3>								
											</div>
												
											<div class="card-body">
												
												
												<form action="user/updateUser" method="post" enctype="multipart/form-data">
								
												<div class="row">	
												
												<div class="col-lg-9 col-xl-9">
													
													<div class="row">				
														<div class="col-lg-6">
														<div class="form-group">
														<label>Full name (required)</label>
														<input name="id" type="hidden" value="${login.id }">
														<input class="form-control" name="userName" type="text" value="${login.userName }" required />
														
														</div>
														</div>

														<div class="col-lg-6">
														<div class="form-group">
														<label>Valid Email (required)</label>
														<input class="form-control" name="email" type="email" value="office@website.com" required />
														</div>
														</div>  
													</div>
													
													<div class="row">				
														<div class="col-lg-6">
														<div class="form-group">
														<label>Password (leave empty not to change)</label>
														<input class="form-control" name="password" type="password" value="${login.password }" />
														</div>
														</div>              			                                
														
														<div class="col-lg-6">
														<div class="form-group">
														<label>Skype</label>
														<input class="form-control" name="skype" type="text" value="skypeid" />
														</div>
														</div>   
													</div>
													
													<div class="row">
														<div class="col-lg-12">
														<button type="submit" class="btn btn-primary">Edit profile</button>
														</div>
													</div>
												
												</div>
												
												
												
												<div class="col-lg-3 col-xl-3 border-left">
													<b>Latest activity</b>: Dec 06 2017, 22:23	
													<br />
													<b>Register date: </b>: Nov 24 2017, 20:32	
													<br />
													<b>Register IP: </b>: 123.456.789
													
													<div class="m-b-10"></div>
													
													<div id="avatar_image">
														<img alt="image" style="max-width:100px; height:auto;" src="assets/images/avatars/admin.png" />
														<br />
														<i class="fa fa-trash-o fa-fw"></i> <a class="delete_image" href="#">Remove avatar</a>
																	
													</div>  
													<div id="image_deleted_text"></div>                      

													
													<div class="m-b-10"></div>
													
													<div class="form-group">
													<label>Change avatar</label> 
													<input type="file" name="image" class="form-control">
													</div>
													
												</div>
												</div>								
												
												</form>										
												
								</div>	
								<!-- end card-body -->								
									
							</div>
							<!-- end card -->					

						</div>
						<!-- end col -->	
															
					</div>
					<!-- end row -->	


            </div>
</div>

