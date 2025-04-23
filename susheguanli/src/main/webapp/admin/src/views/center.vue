<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
                                     <el-col :span="12">
                              <el-form-item v-if="flag=='suguan'"  label='宿管姓名' prop="suguanName">
                                  <el-input v-model="ruleForm.suguanName"  placeholder='宿管姓名' clearable></el-input>
                              </el-form-item>
                          </el-col>

                          <el-col :span="12">
                              <el-form-item v-if="flag=='suguan'"  label='宿管手机号' prop="suguanPhone">
                                  <el-input v-model="ruleForm.suguanPhone"  placeholder='宿管手机号' clearable></el-input>
                              </el-form-item>
                          </el-col>

                          <el-col :span="12">
                              <el-form-item v-if="flag=='suguan'"  label='电子邮箱' prop="suguanEmail">
                                  <el-input v-model="ruleForm.suguanEmail"  placeholder='电子邮箱' clearable></el-input>
                              </el-form-item>
                          </el-col>

                    <el-col :span="12">
                        <el-form-item v-if="flag=='suguan'"  label='楼栋' prop="loudongTypes">
                            <el-select v-model="ruleForm.loudongTypes" placeholder='请选择楼栋'>
                                <el-option
                                        v-for="(item,index) in loudongTypesOptions"
                                        v-bind:key="item.codeIndex"
                                        :label="item.indexName"
                                        :value="item.codeIndex">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                          <el-col :span="12">
                              <el-form-item v-if="flag=='xuesheng'"  label='宿舍' prop="susheId">
                                  <el-input v-model="ruleForm.susheId"  placeholder='宿舍' clearable></el-input>
                              </el-form-item>
                          </el-col>

                          <el-col :span="12">
                              <el-form-item v-if="flag=='xuesheng'"  label='学号' prop="xueshengUuidNumber">
                                  <el-input v-model="ruleForm.xueshengUuidNumber"  placeholder='学号' clearable></el-input>
                              </el-form-item>
                          </el-col>

                          <el-col :span="12">
                              <el-form-item v-if="flag=='xuesheng'"  label='学生姓名' prop="xueshengName">
                                  <el-input v-model="ruleForm.xueshengName"  placeholder='学生姓名' clearable></el-input>
                              </el-form-item>
                          </el-col>

                          <el-col :span="12">
                              <el-form-item v-if="flag=='xuesheng'"  label='学生手机号' prop="xueshengPhone">
                                  <el-input v-model="ruleForm.xueshengPhone"  placeholder='学生手机号' clearable></el-input>
                              </el-form-item>
                          </el-col>

                          <el-col :span="12">
                              <el-form-item v-if="flag=='xuesheng'"  label='电子邮箱' prop="xueshengEmail">
                                  <el-input v-model="ruleForm.xueshengEmail"  placeholder='电子邮箱' clearable></el-input>
                              </el-form-item>
                          </el-col>

                          <el-col :span="12">
                              <el-form-item v-if="flag=='xuesheng'"  label='QQ号' prop="xueshengQq">
                                  <el-input v-model="ruleForm.xueshengQq"  placeholder='QQ号' clearable></el-input>
                              </el-form-item>
                          </el-col>

                        <el-col :span="24">
                            <el-form-item v-if="flag=='xuesheng'" label='学生头像' prop="xueshengPhoto">
                                <file-upload
                                        tip="点击上传照片"
                                        action="file/upload"
                                        :limit="3"
                                        :multiple="true"
                                        :fileUrls="ruleForm.xueshengPhoto?ruleForm.xueshengPhoto:''"
                                        @change="xueshengPhotoUploadChange"
                                ></file-upload>
                            </el-form-item>
                        </el-col>
                    <el-col :span="12">
                        <el-form-item v-if="flag=='xuesheng'"  label='职位' prop="zhiweiTypes">
                            <el-select v-model="ruleForm.zhiweiTypes" disabled placeholder='请选择职位'>
                                <el-option
                                        v-for="(item,index) in zhiweiTypesOptions"
                                        v-bind:key="item.codeIndex"
                                        :label="item.indexName"
                                        :value="item.codeIndex">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item v-if="flag=='xuesheng'"  label='班级' prop="banjiTypes">
                            <el-select v-model="ruleForm.banjiTypes" disabled placeholder='请选择班级'>
                                <el-option
                                        v-for="(item,index) in banjiTypesOptions"
                                        v-bind:key="item.codeIndex"
                                        :label="item.indexName"
                                        :value="item.codeIndex">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' && flag!='suguan'"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      sexTypesOptions : [],




     loudongTypesOptions : [],










     zhiweiTypesOptions : [],
     banjiTypesOptions : [],


    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
          this.sexTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
  });




   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=loudong_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.loudongTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });










   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhiwei_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.zhiweiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=banji_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.banjiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });


  },
  methods: {
    xueshengPhotoUploadChange(fileUrls) {
        this.ruleForm.xueshengPhoto = fileUrls;
    },

    onUpdateHandler() {
                         if((!this.ruleForm.suguanName)&& 'suguan'==this.flag){
                             this.$message.error('宿管姓名不能为空');
                             return
                         }

                             if( 'suguan' ==this.flag && this.ruleForm.suguanPhone&&(!isMobile(this.ruleForm.suguanPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                             if( 'suguan' ==this.flag && this.ruleForm.suguanEmail&&(!isEmail(this.ruleForm.suguanEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.loudongTypes)&& 'suguan'==this.flag){
                             this.$message.error('楼栋不能为空');
                             return
                         }

                         if((!this.ruleForm.susheId)&& 'xuesheng'==this.flag){
                             this.$message.error('宿舍不能为空');
                             return
                         }

                         if((!this.ruleForm.xueshengUuidNumber)&& 'xuesheng'==this.flag){
                             this.$message.error('学号不能为空');
                             return
                         }

                         if((!this.ruleForm.xueshengName)&& 'xuesheng'==this.flag){
                             this.$message.error('学生姓名不能为空');
                             return
                         }

                             if( 'xuesheng' ==this.flag && this.ruleForm.xueshengPhone&&(!isMobile(this.ruleForm.xueshengPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                             if( 'xuesheng' ==this.flag && this.ruleForm.xueshengEmail&&(!isEmail(this.ruleForm.xueshengEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.xueshengQq)&& 'xuesheng'==this.flag){
                             this.$message.error('QQ号不能为空');
                             return
                         }

                         if((!this.ruleForm.xueshengPhoto)&& 'xuesheng'==this.flag){
                             this.$message.error('学生头像不能为空');
                             return
                         }

                         if((!this.ruleForm.zhiweiTypes)&& 'xuesheng'==this.flag){
                             this.$message.error('职位不能为空');
                             return
                         }

                         if((!this.ruleForm.banjiTypes)&& 'xuesheng'==this.flag){
                             this.$message.error('班级不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes)&& this.flag !='users'&& this.flag !='suguan'){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
