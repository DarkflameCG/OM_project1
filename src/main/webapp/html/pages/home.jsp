<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
	<link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="../assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="../assets/css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css"
		href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" />
	<link rel="stylesheet" href="../iconfont/iconfont.css">

	<script src="https://cdn.bootcdn.net/ajax/libs/echarts/4.7.0/echarts.common.min.js"></script>
</head>

<body>
	<div class="container-fluid">

		<div class="row">
			<div class="col-xl-12">
				<div class="breadcrumb-holder">
					<!-- <<h1 class="main-title float-left">首页</h1>
										ol class="breadcrumb float-right">
											<li class="breadcrumb-item">Home</li>
											<li class="breadcrumb-item active">Dashboard</li>
										</ol> -->
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- end row -->


		<div class="row">
			<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
				<div class="card-box noradius noborder bg-default">
					<i class="fa fa-file-text-o float-right text-white"></i>
					<h6 class="text-white text-uppercase m-b-20">请假次数</h6>
					<h1 class="m-b-20 text-white counter">1,587</h1>
					<span class="text-white">15 New Orders</span>
				</div>
			</div>

			<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
				<div class="card-box noradius noborder bg-warning">
					<i class="fa fa-bar-chart float-right text-white"></i>
					<h6 class="text-white text-uppercase m-b-20">外出次数</h6>
					<h1 class="m-b-20 text-white counter">250</h1>
					<span class="text-white">Bounce rate: 25%</span>
				</div>
			</div>

			<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
				<div class="card-box noradius noborder bg-info">
					<i class="fa fa-user-o float-right text-white"></i>
					<h6 class="text-white text-uppercase m-b-20">体检次数</h6>
					<h1 class="m-b-20 text-white counter">120</h1>
					<span class="text-white">25 New Users</span>
				</div>
			</div>
			<div class="col-xs-12 col-md-6 col-lg-6 col-xl-3">
				<div class="card-box noradius noborder bg-danger">
					<i class="fa fa-bell-o float-right text-white"></i>
					<h6 class="text-white text-uppercase m-b-20">就医次数</h6>
					<h1 class="m-b-20 text-white counter">58</h1>
					<span class="text-white">5 New Alerts</span>
				</div>
			</div>
		</div>
		<!-- end row -->
		家属能看到：个人信息、自己的老人信息、收费设置、会员卡充值接口
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-6">
				<div class="card mb-3">
					<div class="card-header">
						<h3><i class="fa fa-line-chart"></i> 缴费记录</h3>
					</div>

					<div class="card-body">
						<!-- <canvas id="lineChart"></canvas> -->
						<div id="chartmain" style="width:600px; height: 400px;"></div>

					</div>
					<div class="card-footer small text-muted">更新时间：11:59 PM</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-6">
				<div class="card mb-3">
					<div class="card-header">
						<h3><i class="fa fa-bar-chart-o"></i> 消费记录</h3>
					</div>

					<div class="card-body">
						<!-- <canvas id="pieChart"></canvas> -->
						<div id="chartmain1" style="width:600px; height: 400px;"></div>

					</div>
					<div class="card-footer small text-muted">更新时间：11:59 PM</div>
				</div>
			</div>
			<!-- <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-3">
				<div class="card mb-3">
					<div class="card-header">
						<h3><i class="fa fa-bar-chart-o"></i> 余额</h3>
					</div>

					<div class="card-body">
						<canvas id="doughnutChart"></canvas>
						<div id="chartmain" style="width:600px; height: 400px;"></div>
					</div>
					<div class="card-footer small text-muted">更新时间：11:59 PM</div>
				</div>
			</div> -->
		</div>
		<!-- end row -->
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-6">
				<div class="card mb-3">
					<div class="card-header">
						<h3><i class="fa fa-users"></i> 充值记录</h3>
						展示家属给这位老人的充值记录。
					</div>
					<div class="card-body">
						<table id="example1" class="table table-bordered table-responsive-xl table-hover display">
							<thead>
								<tr>
									<th>老人姓名</th>
									<th>充值金额</th>
									<th>充值时间</th>
									<th>支付方式</th>
									<th>操作人员</th>
									<th>备注</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Tiger Nixon</td>
									<td>$320,800</td>
									<td>System Architect</td>
									<td>Edinburgh</td>
									<td>61</td>
									<td>2011/04/25</td>
								</tr>
								<tr>
									<td>Garrett Winters</td>
									<td>$170,750</td>
									<td>Accountant</td>
									<td>Tokyo</td>
									<td>63</td>
									<td>2011/07/25</td>
								</tr>
								<tr>
									<td>Ashton Cox</td>
									<td>$86,000</td>
									<td>Junior Technical Author</td>
									<td>San Francisco</td>
									<td>66</td>
									<td>2009/01/12</td>
								</tr>
								<tr>
									<td>Cedric Kelly</td>
									<td>$433,060</td>
									<td>Senior Javascript Developer</td>
									<td>Edinburgh</td>
									<td>22</td>
									<td>2012/03/29</td>
								</tr>
								<tr>
									<td>Airi Satou</td>
									<td>$162,700</td>
									<td>Accountant</td>
									<td>Tokyo</td>
									<td>33</td>
									<td>2008/11/28</td>
								</tr>
								<tr>
									<td>Brielle Williamson</td>
									<td>$372,000</td>
									<td>Integration Specialist</td>
									<td>New York</td>
									<td>61</td>
									<td>2012/12/02</td>
								</tr>
								<tr>
									<td>Herrod Chandler</td>
									<td>$137,500</td>
									<td>Sales Assistant</td>
									<td>San Francisco</td>
									<td>59</td>
									<td>2012/08/06</td>
								</tr>
								<tr>
									<td>Rhona Davidson</td>
									<td>$327,900</td>
									<td>Integration Specialist</td>
									<td>Tokyo</td>
									<td>55</td>
									<td>2010/10/14</td>
								</tr>
								<tr>
									<td>Colleen Hurst</td>
									<td>$205,500</td>
									<td>Javascript Developer</td>
									<td>San Francisco</td>
									<td>39</td>
									<td>2009/09/15</td>
								</tr>
								<tr>
									<td>Sonya Frost</td>
									<td>$103,600</td>
									<td>Software Engineer</td>
									<td>Edinburgh</td>
									<td>23</td>
									<td>2008/12/13</td>
								</tr>
								<tr>
									<td>Jena Gaines</td>
									<td>$90,560</td>
									<td>Office Manager</td>
									<td>London</td>
									<td>30</td>
									<td>2008/12/19</td>
								</tr>
								<tr>
									<td>Quinn Flynn</td>
									<td>$342,000</td>
									<td>Support Lead</td>
									<td>Edinburgh</td>
									<td>22</td>
									<td>2013/03/03</td>
								</tr>
								<tr>
									<td>Fiona Green</td>
									<td>$850,000</td>
									<td>Chief Operating Officer (COO)</td>
									<td>San Francisco</td>
									<td>48</td>
									<td>2010/03/11</td>
								</tr>
								<tr>
									<td>Shou Itou</td>
									<td>$163,000</td>
									<td>Regional Marketing</td>
									<td>Tokyo</td>
									<td>20</td>
									<td>2011/08/14</td>
								</tr>
								<tr>
									<td>Jonas Alexander</td>
									<td>$86,500</td>
									<td>Developer</td>
									<td>San Francisco</td>
									<td>30</td>
									<td>2010/07/14</td>
								</tr>
								<tr>
									<td>Shad Decker</td>
									<td>$183,000</td>
									<td>Regional Director</td>
									<td>Edinburgh</td>
									<td>51</td>
									<td>2008/11/13</td>
								</tr>
								<tr>
									<td>Michael Bruce</td>
									<td>$183,000</td>
									<td>Javascript Developer</td>
									<td>Singapore</td>
									<td>29</td>
									<td>2011/06/27</td>
								</tr>
								<tr>
									<td>Donna Snider</td>
									<td>$112,000</td>
									<td>Customer Support</td>
									<td>New York</td>
									<td>27</td>
									<td>2011/01/25</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div><!-- end card-->
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-3">
				<div class="card mb-3">
					<div class="card-header">
						<h3><i class="fa fa-star-o"></i> 体验服务项目次数</h3>
						你的体验服务项目次数还剩多少。
					</div>
					<div class="card-body">
						<p class="font-600 m-b-5">Task 1 <span class="text-primary pull-right"><b>95%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-primary" role="progressbar"
								style="width: 95%" aria-valuenow="95" aria-valuemin="0" aria-valuemax="95"></div>
						</div>

						<div class="m-b-20"></div>

						<p class="font-600 m-b-5">Task 2 <span class="text-primary pull-right"><b>88%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-primary" role="progressbar"
								style="width: 88%" aria-valuenow="88" aria-valuemin="0" aria-valuemax="88"></div>
						</div>

						<div class="m-b-20"></div>

						<p class="font-600 m-b-5">Task 3 <span class="text-info pull-right"><b>75%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-info" role="progressbar"
								style="width: 78%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="75"></div>
						</div>

						<div class="m-b-20"></div>

						<p class="font-600 m-b-5">Task 4 <span class="text-info pull-right"><b>70%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-info" role="progressbar"
								style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="70"></div>
						</div>

						<div class="m-b-20"></div>

						<p class="font-600 m-b-5">Task 5 <span class="text-warning pull-right"><b>68%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-warning" role="progressbar"
								style="width: 68%" aria-valuenow="68" aria-valuemin="0" aria-valuemax="68"></div>
						</div>

						<div class="m-b-20"></div>

						<p class="font-600 m-b-5">Task 6 <span class="text-warning pull-right"><b>65%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-warning" role="progressbar"
								style="width: 65%" aria-valuenow="65" aria-valuemin="0" aria-valuemax="65"></div>
						</div>

						<div class="m-b-20"></div>

						<p class="font-600 m-b-5">Task 7 <span class="text-danger pull-right"><b>55%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-danger" role="progressbar"
								style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="55"></div>
						</div>

						<div class="m-b-20"></div>

						<p class="font-600 m-b-5">Task 8 <span class="text-danger pull-right"><b>40%</b></span></p>
						<div class="progress">
							<div class="progress-bar progress-bar-striped progress-xs bg-danger" role="progressbar"
								style="width: 40%" aria-valuenow="40" aria-valuemin="0" aria-valuemax="40"></div>
						</div>
					</div>
					<div class="card-footer small text-muted">更新时间： 11:59 PM</div>
				</div><!-- end card-->
			</div>
		</div>
	</div>

	<script type="text/javascript">
		//指定图标的配置和数据
		var option = {
			tooltip: {},
			legend: {
				data: ['用户来源']
			},
			xAxis: {
				data: ["周日", "周一", "周二", "周三", "周四", "周五", "周六",]
			},
			yAxis: {

			},
			series: [{
				name: '访问量',
				type: 'line',
				data: [500, 200, 360, 100,200,200,200]
			}]
		};
		//初始化echarts实例
		var myChart = echarts.init(document.getElementById('chartmain'));
		var myChart1 = echarts.init(document.getElementById('chartmain1'));

		//使用制定的配置项和数据显示图表
		myChart.setOption(option);
		myChart1.setOption(option);
	</script>
</body>

</html>