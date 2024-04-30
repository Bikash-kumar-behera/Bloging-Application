import { NextRequest, NextResponse } from "next/server";
import axios from "axios";

export async function POST(request) {
    try {
        const reqBody = await request.json();
        const { postId } = reqBody;
        const url = process.env.BACKEND_URL + `/post/${postId}`;
        const posts = await axios.get(url);

        return NextResponse.json({
            message: "Post featch successful",
            data: posts.data.data,
        });
    } catch (error) {
        return NextResponse.json({ error: error.message }, { status: 400 });
    }
}
