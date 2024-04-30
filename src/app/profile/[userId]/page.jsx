"use client"
import { useEffect, useState } from "react";
// import { posts, writer } from "@/utils/dummyData";
import Card from "@/components/other/Card";
import Button from "@/components/other/Button";
import axios from "axios";
import profilePicture from "/public/user.png";
import Image from "next/image";

const WriterPage = ({ params }) => {
    const { userId } = params;
    const [writer, setWriter] = useState(null);
    const [user, setUser] = useState("");
    const [posts, setPost] = useState(null);
    const [follow, setFollow] = useState(true);
    const [followingCount, setFollowingCount] = useState(0);
    const [backendUrl, setBackEndUrl] = useState("");



    const handleFollow = ()=>{
        if(follow){
            setFollowingCount(followingCount+1)
        }else{
            setFollowingCount(followingCount-1)
        }
        // const res = 
        setFollow(!follow)
    }

    //   const { userId } = useParams();
    const fetchWriterInfo = async () => {
        const urlres = await axios.get("/api/backendurl");
        setBackEndUrl(urlres.data.data);
        const responce = await axios.post("/api/users/checkCookies");
        if (responce.data.data) {
            setUser({ token: responce.data.data });
        }
        const res = await axios.post(`/api/profiledata`,{userId});
        console.log(res.data.data);
        setPost(res.data.data.posts.data);
        setWriter(res.data.data.user);
        setFollowingCount(res.data.data.user.followings.length);
    };

    useEffect(() => {
        fetchWriterInfo();
    }, []);
    //   const handleFollow = async () => {
    //     const res = await followWriter(id, user?.token);
    //     if (res?.success === true) {
    //       fetchWriterInfo();
    //     }
    //   };

    if (!writer)
        return (
            <div className="w-full h-full py-8 flex items-center justify-center">
                <span className="text-lg text-slate-500">No Writer Found</span>
            </div>
        );
    return (
        <div className="px-0 2xl:px-20 ">
            <div className="w-full md:h-60 flex flex-col gap-5 items-center md:flex-row bg-black dark:bg-gradient-to-r from-[#020b19] via-[#071b3e] to-[#020b19]  mt-5 mb-10 rounded-md p-5 md:px-20">
                <Image
                    src={profilePicture}
                    alt="Writer"
                    className="w-48 h-48 rounded-full border-4 border-slate-400 object-cover"
                />
                <div className="w-full h-full flex flex-col gap-y-5 md:gap-y-8  items-center justify-center">
                    <h2 className="text-white text-4xl 2xl:text-5xl font-bold">
                        {writer?.name}
                    </h2>
                    <div className="flex gap-10">
                        <div className="flex flex-col items-center">
                            <p className="text-gray-300 text-2xl font-semibold">
                                {followingCount}
                            </p>
                            <span className="text-gray-500">Following</span>
                        </div>
                        <div className="flex flex-col items-center">
                            <p className="text-gray-300 text-2xl font-semibold">
                                {posts?.length}
                            </p>
                            <span className="text-gray-500">Posts</span>
                        </div>
                    </div>

                    {user && (
                        <div>
                            {user ? (
                                <Button
                                    label={follow ? "Follow" : "Unfollow"}
                                    styles="text-slate-800 text-semibold md:-mt-4 px-6 py-1 rounded-full bg-white"
                                    onClick={handleFollow}
                                />
                            ) : (
                                <div className="flex items-center justify-center gap-2 text-white text-semibold md:-mt-4 px-6 py-1 rounded-full border">
                                    <span>Following</span>
                                    {/* <FaUserCheck /> */}
                                </div>
                            )}
                        </div>
                    )}
                </div>
            </div>

            <div className="w-full flex flex-col md:flex-row gap-10 2xl:gap-20">
                <div className="w-full md:w-full flex flex-col gap-y-28 md:gap-y-14">
                    {posts?.length === 0 ? (
                        <div className="w-full h-full py-8 flex  justify-center">
                            <span className="text-lg text-slate-500">
                                No Post Available
                            </span>
                        </div>
                    ) : (
                        <>
                            {posts?.map((post, index) => (
                                <Card key={post?._id} post={post} url={backendUrl} />
                            ))}
                        </>
                    )}
                </div>
            </div>
        </div>
    );
};

export default WriterPage;
